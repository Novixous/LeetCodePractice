package com.practice.sort;

import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 5, 6, 1, 2, 3, 4};
//        bubbleSort(ints);
        selectionSort(ints);
        Arrays.stream(ints).asLongStream().forEach(value -> System.out.print(value));
    }

    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            int tmp = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = tmp;
        }
    }
}
