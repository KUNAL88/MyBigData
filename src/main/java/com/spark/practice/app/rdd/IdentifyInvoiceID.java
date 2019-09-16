package com.spark.practice.app.rdd;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;

public class IdentifyInvoiceID {

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

        JavaRDD<String> retailRDD=javaSparkContext.textFile("hdfs://localhost:9000/user/kunal/practice/spark/Online-Retail.csv");

       /* System.out.println(retailRDD.count());
        System.out.println(retailRDD.take(10));*/
      /*  retailRDD=retailRDD.map(new Function<String, String>() {
            @Override
            public String call(String s) throws Exception {

                String[] eachWord=s.split(",");

                return eachWord[0];
            }
        });

        System.out.println(retailRDD.take(10));*/

       retailRDD=retailRDD.map(new Function<String, String>() {
           @Override
           public String call(String s) throws Exception {

             return s.replace("United Kingdom","UK");
              /*
               String[] rowSplit=s.split(",");

               if(rowSplit.length==8
                       && rowSplit[7].equalsIgnoreCase("United Kingdom")){
                   rowSplit[7]="UK";
               }
               System.out.println(rowSplit[7]);
               return rowSplit.toString();*/
           }
       });

      // System.out.println(retailRDD.take(10));

       retailRDD.saveAsTextFile("hdfs://localhost:9000/user/kunal/practice/output/1");


    }
}
