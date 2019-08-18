package com.kunal.other;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {

        SparkConf sparkConfig=new SparkConf();
        sparkConfig
                .setAppName("Spark-Demo-By-Kunal")
                .setMaster("local[2]");

        SparkSession session=SparkSession.builder()
                .config(sparkConfig)
                .enableHiveSupport()
                .getOrCreate();

        SparkContext sc=session.sparkContext();

        Encoder<Integer> integerEncoder = Encoders.INT();
        Dataset<Integer> primitiveDS = session
                .createDataset(Arrays.asList(1, 2, 3), integerEncoder);

        primitiveDS.show(false);
    }
}
