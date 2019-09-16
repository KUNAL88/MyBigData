package com.kunal.rdd;

import com.kunal.util.SparkSeesionUtil;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DemoRdd {

    public static void main(String[] args)throws IOException {

        SparkSession session= SparkSeesionUtil.createSparkSession();
        SparkContext sc=session.sparkContext();

       // SQLContext hc=session.sqlContext();

        RDD<String> file=sc.textFile("hdfs://localhost:9000/user/kunal/text/sample.text",1);
        file.persist(StorageLevel.MEMORY_ONLY());

        /*HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"US");
        map.put(2,"IN");
        map.put(3,"UK");*/

        String[] val={"US","IN","UK"};


        /* RDD<Integer> length=file.map(new Function<String, Integer>() {
            public Integer call(String s) { return s.length(); }
        });*/

    }
}
