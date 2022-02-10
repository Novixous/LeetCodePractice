package com.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {
        int[] inputs = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] result = mergeSort(inputs);
        printArray(result);
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int right[]) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result.add(left[leftIndex]);
                leftIndex++;
            } else {
                result.add(right[rightIndex]);
                rightIndex++;
            }
        }
        for (int i = leftIndex; i < left.length; i++) {
            result.add(left[i]);
        }
        for (int i = rightIndex; i < right.length; i++) {
            result.add(right[i]);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printArray(int[] array){
        StringJoiner joiner = new StringJoiner(", ");
        for (int i : array) {
            joiner.add(String.valueOf(i));
        }
        System.out.println(joiner.toString());
    }
}
