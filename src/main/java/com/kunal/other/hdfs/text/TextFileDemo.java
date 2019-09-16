package com.kunal.other.hdfs.text;

import com.kunal.util.SparkSeesionUtil;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.Arrays;

public class TextFileDemo {

    public static void main(String[] args) {
        SparkSession session= SparkSeesionUtil.createSparkSession();

        Dataset<Row> textDataset=session
                .readStream()
                .text("hdfs://localhost:9000/user/kunal/text/input/");

        System.out.println(textDataset.isStreaming());
        textDataset.printSchema();

        Dataset<String> words = textDataset
                .as(Encoders.STRING())
                .flatMap(
                        (FlatMapFunction<String, String>) x ->
                                Arrays.asList(x.split(" ")).iterator(), Encoders.STRING());

      //  Dataset<Row> wordCounts = words.groupBy("value").count();

        Dataset<Row> output=words.selectExpr("value");

        DateTime dt = new DateTime();
        Timestamp ts= new Timestamp(dt.getMillis());

        output= output.withColumn("timestamp",functions.lit(ts));

        Dataset<Row> windowedCounts = output
                .withWatermark("timestamp","2 minutes")
                .groupBy(
                functions.window(functions.col("timestamp"), "10 minutes", "5 minutes"),
                words.col("value")
        ).count();

        //Note Append mode is not supported without watermarking ...
        StreamingQuery query = windowedCounts.writeStream()
                .outputMode("Append")
               // .format("console")
                .format("parquet")
               // .option("sep", ",")
                .option("path","hdfs://localhost:9000/user/kunal/text/output")
                .option("checkpointLocation", "hdfs://localhost:9000/user/kunal/text/chk")
                .trigger(Trigger.ProcessingTime("60 seconds"))
                .start();

        try{
            query.awaitTermination();
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
