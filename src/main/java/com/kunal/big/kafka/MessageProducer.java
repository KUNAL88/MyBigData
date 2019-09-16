package com.kunal.big.kafka;

import com.kunal.config.KafkaConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;
import org.apache.spark.sql.types.*;
import org.spark_project.guava.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class MessageProducer {

    public static void main(String[] args)throws Exception {

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

        ArrayList<String> listOfRandomWords=new ArrayList<>();
        listOfRandomWords.add("Kunal"); /*listOfRandomWords.add("Sharma");
        listOfRandomWords.add("kit");   listOfRandomWords.add("coep");*/

        Row row= RowFactory.create(listOfRandomWords.toArray());
       /* ArrayList<Row> list=new ArrayList<>();
        list.add(row);*/
        List<Row> rowList = ImmutableList.of(row);
        StructField schema= DataTypes.createStructField("Name",DataTypes.StringType,false);
        StructType structType=DataTypes.createStructType(
                new StructField[]{schema});


        StructType schemata = DataTypes.createStructType(
                new StructField[]{
                        DataTypes.createStructField("NAME",
                                DataTypes.StringType, false,Metadata.empty())

                });

        Dataset<Row> ds_row=session.createDataFrame(rowList,schemata);

        StreamingQuery query =ds_row.selectExpr("CAST(NAME AS STRING)")
        .writeStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", config.getKafkaBootstarpServer())
                .option("subscribe", config.getKafkaTopic())
                .trigger(Trigger.ProcessingTime("2 seconds"))
                .start();

        query.awaitTermination();


    }
}
