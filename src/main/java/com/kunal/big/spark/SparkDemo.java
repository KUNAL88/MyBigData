package com.kunal.big.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkDemo {

    private static boolean isLocalMode=true;
    private static String sourceTableName="default.stud_info";

    public static void main(String[] args) {

        SparkConf sparkConfig=new SparkConf();
        sparkConfig.setAppName("Spark-Demo-By-Kunal");

        if(isLocalMode){
            sparkConfig.setMaster("local[2]");
        }

        SparkSession session=SparkSession.builder()
                .config(sparkConfig)
                .enableHiveSupport()
                .getOrCreate();

     //   session.sql("create table "+sourceTableName+" (rollNO int,name string)");
      //  session.sql("insert into table "+sourceTableName+" values (1,'kunal')");

        Dataset<Row> ds=session.read().table(sourceTableName);

        ds.show(10);

    }
}
