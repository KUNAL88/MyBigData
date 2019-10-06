package com.spark.practice.app.rdd;

import com.spark.practice.config.AppConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import org.joda.time.Duration;
import org.joda.time.Instant;
import scala.Tuple2;

public class VgSales {

    public static void main(String[] args) {

        Instant startTime=Instant.now();
        System.out.println(" End Time "+startTime.getMillis());

        if(args.length<1){
            System.out.println(" Argument Missing : property file expected ...");
            System.exit(0);
        }

        AppConfig appConfig=new AppConfig(args[0]);
        SparkConf sparkConf=new SparkConf();
        sparkConf.setAppName("MyVgSales");
        if(appConfig.getIsLocal()){
            sparkConf.setMaster("local[2]");
        }

        SparkSession sparkSession=SparkSession
                .builder()
                .config(sparkConf)
                .getOrCreate();


        SparkContext sparkContext=sparkSession.sparkContext();

        JavaSparkContext javaSparkContext=JavaSparkContext.fromSparkContext(sparkContext);

        JavaRDD<String> gamingSalesRDD=javaSparkContext.textFile("hdfs://localhost:9000/user/kunal/com.spark.practice.practice/spark/vgsales_cleaned.csv");

        gamingSalesRDD=gamingSalesRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                if(s.contains("Publisher")){
                    return false;
                }
                return true;
            }
        });

        countOfEachPlatFrom(gamingSalesRDD);
        totalSaleOfEachPlatform(gamingSalesRDD);
        topTenPlatformByGlobalSales(gamingSalesRDD);

        Instant endTime=Instant.now();
        System.out.println(" End Time "+endTime.getMillis());
        System.out.println("Total Time of Execution "+ Duration.millis(endTime.getMillis()-startTime.getMillis()).getStandardSeconds());


    }


    private static void countOfEachPlatFrom(JavaRDD<String> sales){


        JavaPairRDD<String, Integer> platformKey = sales.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {

                String[] fields = s.split(",");

                return new Tuple2<>(fields[2],new Integer(1));
            }
        });

        Function<Integer,Integer> createACC= new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer i1) throws Exception {
                return 1;
            }
        };

       // Function2<>

        JavaPairRDD<String, Integer> eachPlatFormCount= platformKey.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer val1, Integer val2) throws Exception {
                return val1+val2;
            }
        });

        System.out.println("Num of times each platform appers : ");
        System.out.println(eachPlatFormCount.collectAsMap());
    }

    private static void totalSaleOfEachPlatform(JavaRDD<String> sales){

        JavaPairRDD<String, Double> platformKey = sales.mapToPair(new PairFunction<String, String, Double>() {
            @Override
            public Tuple2<String, Double> call(String s) throws Exception {

                String[] fields = s.split(",");
                double totalSales=0.0;

                    totalSales+=Double.parseDouble(fields[6]);
                    totalSales+=Double.parseDouble(fields[7]);
                    totalSales+=Double.parseDouble(fields[8]);
                    totalSales+=Double.parseDouble(fields[9]);
                    totalSales+=Double.parseDouble(fields[10]);

                return new Tuple2<>(fields[2],new Double(totalSales));
            }
        });

        JavaPairRDD<String,Double> totalSale=platformKey.reduceByKey(new Function2<Double, Double, Double>() {
            @Override
            public Double call(Double aDouble, Double aDouble2) throws Exception {
                return new Double(aDouble+aDouble2);
            }
        });

        System.out.println("Total Sale of Each Gaming Platform ");
        System.out.println(totalSale.collectAsMap());
    }

    private static void topTenPlatformByGlobalSales(JavaRDD<String> sales){

        JavaPairRDD<String, Double> platformKey = sales.mapToPair(new PairFunction<String, String, Double>() {
            @Override
            public Tuple2<String, Double> call(String s) throws Exception {

                String[] fields = s.split(",");
                double totalSales=0.0;

                totalSales+=Double.parseDouble(fields[10]);

                return new Tuple2<>(fields[2],new Double(totalSales));
            }
        });//.max(new CalculateMaxForPairRDD());

        Tuple2<String,Double> maxGlobalSales=platformKey.max(new CalculateMaxForPairRDD());
        System.out.println(" Max Global Sales for each platform ");
        System.out.println(maxGlobalSales._1+" --- "+maxGlobalSales._2);

        platformKey=platformKey.reduceByKey(new Function2<Double, Double, Double>() {
            @Override
            public Double call(Double aDouble, Double aDouble2) throws Exception {
                return aDouble+aDouble2;
            }
        }).sortByKey();

        System.out.println(platformKey.takeOrdered(10,new CalculateMaxForPairRDD()));
    }
}
