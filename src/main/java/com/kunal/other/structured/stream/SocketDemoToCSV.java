package com.kunal.other.structured.stream;

import com.kunal.other.Util;
import com.kunal.util.SparkSeesionUtil;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.Trigger;
import org.apache.spark.sql.types.StructType;

public class SocketDemoToCSV {

    public static void main(String[] args)throws StreamingQueryException {

        SparkSession spark= SparkSeesionUtil.createSparkSession();//getSparkSession();

        Dataset<Row> socketDF = spark
                .readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 9999)
                .load();

        socketDF.isStreaming();    // Returns True for DataFrames that have streaming sources

        socketDF.printSchema();

// Read all the csv files written atomically in a directory
        StructType userSchema = new StructType()
                .add("name", "string")
                .add("age", "integer");

        Dataset<Row> csvDF = spark
                .readStream()
                .option("sep", ",")
                .schema(userSchema)      // Specify schema of the csv files
                .csv("src/main/resources/output/");    // Equivalent to format("csv").load("/path/to/directory")

//        csvDF.show(false);

       /* StreamingQuery query = csvDF.writeStream()
                .outputMode("append")
                .format("console")
                .trigger(Trigger.ProcessingTime("10 seconds"))
                .start();*/

        StreamingQuery query =  csvDF
                .writeStream()
                .format("parquet")
               // .trigger(Trigger.Continuous("15 second"))
                .option("checkpointLocation", "src/main/resources/parquet/check")
                .option("path", "src/main/resources/parquet/output")
                .trigger(Trigger.ProcessingTime("10 seconds"))
                .start();

        query.awaitTermination();

    }
}
