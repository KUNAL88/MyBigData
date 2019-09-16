package com.kunal.json;

import com.kunal.config.KafkaConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalog.Function;

import java.io.IOException;

public class ReaderWriter {

    public static void main(String[] args) throws IOException{

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


       // Dataset<Row> row =session.read().json("src/main/resources/json/people.json");

        Dataset<Row> row=session
                .read()
                .json("hdfs://localhost:9000/user/kunal/json/people.json");

        row.printSchema();
        row.createOrReplaceTempView("people");

       // row.select("name").show(false);

       // session.sql("SELECT name FROM people").show(10);



    }
}
