package com.spark.practice.app.rdd;

import java.io.Serializable;
import java.util.Comparator;

public class CalculateMax implements Serializable,Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
    }
}
