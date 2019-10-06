package com.spark.practice.app.rdd;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

public class App {

    public static void main(String[] args) {

        if(args.length<1){
            System.out.println(" Argument Missing : property file expected ...");
            System.exit(0);
        }

        AppConfig appConfig=new AppConfig(args[0]);
        SparkConf sparkConf=new SparkConf();
        if(appConfig.getIsLocal()){
            sparkConf.setMaster("local[2]");
        }

        SparkSession sparkSession=SparkSession
                .builder()
                .config(sparkConf)
                .getOrCreate();


        SparkContext sparkContext=sparkSession.sparkContext();

        JavaSparkContext javaSparkContext=JavaSparkContext.fromSparkContext(sparkContext);

        JavaRDD<String> rdd= javaSparkContext
                .textFile("hdfs://localhost:9000/user/kunal/com.spark.practice.practice/spark/sample_file1.txt",2);

        JavaRDD<Integer> stringLength=rdd.map(new Function<String, Integer>() {
            @Override
            public Integer call(String s) throws Exception {
                    return s.length();
            }
        });

        System.out.println(stringLength.collect());

      //  stringLength.reduce(new Fun)

    }
}
