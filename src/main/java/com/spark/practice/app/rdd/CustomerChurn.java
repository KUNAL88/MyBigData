package com.spark.practice.app.rdd;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;

public class CustomerChurn implements Serializable {

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

        JavaRDD<String> customerChurnRDD=javaSparkContext.textFile("hdfs://localhost:9000/user/kunal/com.spark.practice.practice/spark/customer-churn.csv");

        customerChurnRDD=customerChurnRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {

                if(s.contains("state")){
                    return false;
                }

                return true;
            }
        });

       // findUniqueNumOfState(customerChurnRDD);
        findMaxNumOfVmailMsg(customerChurnRDD);


    }

    private static void findMaxNumOfVmailMsg(JavaRDD<String> customerChurnRDD){

        Integer maxVmailMessages= customerChurnRDD.map(new Function<String, Integer>() {
            @Override
            public Integer call(String s) throws Exception {

                String[] fields=s.split(",");
                return Integer.parseInt(fields[6]);
            }
        }).max(new CalculateMax());

        System.out.println(" Max Num of vmail message is "+maxVmailMessages);

        JavaRDD<String> listOfCustomerHavingMaxVmailMessage=customerChurnRDD.filter(
                new Function<String, Boolean>() {
                    @Override
                    public Boolean call(String s) throws Exception {

                        String[] fields=s.split(",");
                        if(Integer.parseInt(fields[6])==maxVmailMessages){
                            return true;
                        }
                        return false;
                    }
                }
        );

        System.out.println("Customer Having max VMail Messages are as follows ");
        System.out.println(listOfCustomerHavingMaxVmailMessage.collect());


    }

    private static void findUniqueNumOfState(JavaRDD<String> customerChurnRDD){
        JavaRDD<String> listOfUniqueState= customerChurnRDD.map(new Function<String, String>() {
            @Override
            public String call(String s) throws Exception {

                String[] fields=s.split(",");
                return fields[0];
            }
        }).distinct();


        System.out.println("List of Unique States : ");
        System.out.println(listOfUniqueState.collect());
        System.out.println(" Total Number of unique States "+listOfUniqueState.count());
    }
}

