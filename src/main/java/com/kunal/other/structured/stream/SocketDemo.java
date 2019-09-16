package com.kunal.other.structured.stream;

import com.kunal.other.Util;
import com.kunal.util.SparkSeesionUtil;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.Trigger;

import java.util.Arrays;

public class SocketDemo {

    public static void main(String[] args) throws StreamingQueryException {

        SparkSession spark= SparkSeesionUtil.createSparkSession();// Util.getSparkSession();

        Dataset<Row> lines = spark
                .readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 9999)
                .load();

        Dataset<String> words = lines
                .as(Encoders.STRING())
                .flatMap(
                        (FlatMapFunction<String, String>) x ->
                                Arrays.asList(x.split(" ")).iterator(), Encoders.STRING());

        Dataset<Row> wordCounts = words.groupBy("value").count();

        StreamingQuery query = wordCounts.writeStream()
                .outputMode("complete")
                .format("console")
                .trigger(Trigger.ProcessingTime("10 seconds"))
                .start();

        query.awaitTermination();
    }
}
