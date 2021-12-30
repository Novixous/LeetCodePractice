package com.practice.recursive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

public class Fibonacci {
    public static HashMap<Long, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getNumberIterative(1000000L));
//        System.out.println(getNumberRec(8000L));
    }

    public static BigInteger getNumberIterative(Long index) {
        if (index <= 1) {
            return BigInteger.valueOf(index);
        }
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.ONE;
        BigInteger number = BigInteger.ZERO;
        for (int i = 2; i <= index; i++) {
            System.out.println(i);
            number = left.add(right);
            left = right;
            right = number;
        }
        return number;
    }

    public static BigInteger getNumberRec(Long index) {
        if (index <= 1) {
            return BigInteger.valueOf(index);
        } else {
            if(cache == null){
                cache = new HashMap<>();
            }
            if(cache.containsKey(index)){
                return cache.get(index);
            }
            BigInteger value = getNumberRec(index - 1).add(getNumberRec(index - 2));
            cache.put(index, value);
            return value;
        }
    }
}
