package com.kunal.other.structured.stream;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class Util {

    static SparkSession getSparkSession(){

        SparkConf sparkConfig=new SparkConf();
        sparkConfig
                .setAppName("Spark-Demo-By-Kunal")
                .setMaster("local[2]");

        SparkSession session=SparkSession.builder()
                .config(sparkConfig)
                .enableHiveSupport()
                .getOrCreate();

        return session;
    }
}
