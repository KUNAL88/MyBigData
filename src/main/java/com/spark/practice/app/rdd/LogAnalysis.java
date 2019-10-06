package com.spark.practice.app.rdd;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;

public class LogAnalysis {

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

        JavaRDD<String> logRDD=javaSparkContext
                .textFile("hdfs://localhost:9000/user/kunal/com.spark.practice.practice/spark/access_log_Jul95_empty_lines.txt");

        logRDD=logRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {

                if(s.length()==0){
                    return true;
                }
                return false;
            }
        });
    }
}
