package com.practice.recursive;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialRec(5));
        System.out.println(factorialIterative(5));
    }

    public static int factorialRec(int number) {
        if(number <= 2){
            return number;
        }
        if (number == 1) {
            return number;
        }
        return number * factorialRec(number - 1);
    }

    public static int factorialIterative(int number) {
        if(number <= 2){
            return number;
        }
        int result = 1;
        while (number != 1) {
            result *= number--;
        }
        return result;
    }
}
