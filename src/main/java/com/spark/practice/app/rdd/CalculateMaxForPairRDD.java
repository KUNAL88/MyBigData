package com.spark.practice.app.rdd;

import scala.Serializable;
import scala.Tuple2;

import java.util.Comparator;

public class CalculateMaxForPairRDD implements Comparator<Tuple2<String,Double>>, Serializable {

    @Override
    public int compare(Tuple2<String, Double> o1, Tuple2<String, Double> o2) {
        return o1._2 > o2._2 ? -1 : o1._2 < o2._2 ? 1 : 0;
    }
}
