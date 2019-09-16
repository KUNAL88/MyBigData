package com.kunal.util;

import com.kunal.config.KafkaConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SparkSeesionUtil {

    public static SparkSession createSparkSession(){

        String configPath="./src/main/resources/local.properties";
        KafkaConfig config=null;

        try {
            config=new KafkaConfig(configPath);
        }catch (IOException e){
            System.out.println("Exception while reading config"+e);
        }

        System.out.println(config.toString());

        SparkConf sparkConf=new SparkConf();
        sparkConf.setAppName("Spark-Kakfa-Message-Consumer");
        if(config.getIslocal()){
            sparkConf.setMaster("local[2]");
        }

       /* JavaSparkContext jsc=new JavaSparkContext(sparkConf);
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"US");

        Broadcast<Map> mapBroadcast=jsc.broadcast(map);

        mapBroadcast.getValue().get(1);*/

        SparkSession session=SparkSession
                .builder()
                .config(sparkConf)
                .getOrCreate();

        return session;
    }
}
