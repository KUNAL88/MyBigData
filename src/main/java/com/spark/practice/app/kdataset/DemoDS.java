package com.spark.practice.app.kdataset;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.joda.time.Duration;
import org.joda.time.Instant;


public class DemoDS {

    public static void main(String[] args) {

        Instant startTime=Instant.now();
        System.out.println(" End Time "+startTime.getMillis());
        if(args.length<1){
            System.out.println(" Argument Missing : property file expected ...");
            System.exit(0);
        }

        AppConfig appConfig=new AppConfig(args[0]);
        SparkConf sparkConf=new SparkConf();
        if(appConfig.getIsLocal()){
            sparkConf.setMaster("local[4]");
        }

        SparkSession sparkSession=SparkSession
                .builder()
                .config(sparkConf)
                .getOrCreate();

        Dataset<Row> dataset=sparkSession
                .read()
                .csv("hdfs://localhost:9000/user/kunal/com.spark.practice.practice/spark/customer-churn.csv")
                .repartition(2);


      //  dataset.select(functions.col("_c0")).show(false);

        dataset.select(functions.col("_c0"),functions.col("_c20"),functions.col("_c9"))
                .where(functions.col("_c0").equalTo("OH")
                        .or(functions.col("_c0").equalTo("NY"))
                        .and(functions.col("_c20")).equalTo("TRUE")).show(false);
              //  .agg(functions.sum("_c9")).show(false);
               // .and(functions.col("_c0").equalTo("NY"))).show(false);

       System.out.println(dataset.rdd().getNumPartitions());
        //System.out.println(sparkSession.sparkContext());

      // dataset.select(functions.col("*")).show(false);

       Instant endTime=Instant.now();
       System.out.println(" End Time "+endTime.getMillis());
       System.out.println("Total Time of Execution "+ Duration.millis(endTime.getMillis()-startTime.getMillis()).getStandardSeconds());

    }
}
