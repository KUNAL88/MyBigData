package com.kunal.big.kafka;

import com.kunal.config.KafkaConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;


public class MessageConsumer {

    public static void main(String[] args)throws Exception {

        String configPath="./src/main/resources/local.properties";
        KafkaConfig config=new KafkaConfig(configPath);
        System.out.println(config.toString());


        SparkConf sparkConf=new SparkConf();
        sparkConf.setAppName("Spark-Kakfa-Message-Consumer");
        if(config.getIslocal()){
            sparkConf.setMaster("local[2]");
        }

        SparkSession session=SparkSession
                .builder()
                .config(sparkConf)
                .getOrCreate();

      //  String startOffset=

        Dataset<Row> lines = session
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", config.getKafkaBootstarpServer())
                .option("subscribe", config.getKafkaTopic())
              //  .option("startingOffsets",)
                .load();
            //    .selectExpr("CAST(value AS STRING)")
            //    .as(Encoders.STRING());

       Dataset<String> words= lines.selectExpr("CAST(value AS STRING)").as(Encoders.STRING());

       System.out.println("Now Writing Query ....");
        StreamingQuery query = words.writeStream()
                //.outputMode("complete")
                .outputMode(OutputMode.Append())
                .format("console")
                .trigger(Trigger.ProcessingTime("2 seconds"))
                .start();

        query.awaitTermination();

    }

}
