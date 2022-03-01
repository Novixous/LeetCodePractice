package com.practice.sort;

import java.util.StringJoiner;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        quickSort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int[] quickSort(int[] array, int left, int right) {
        int len = array.length;
        int pivot;
        int partitionIndex;

        if (left < right) {
            pivot = right;
            partitionIndex = partition(array, pivot, left, right);

            //sort left and right
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    public static int partition(int[] array, int pivot, int left, int right) {
        int pivotValue = array[pivot];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    public static void printArray(int[] array) {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i : array) {
            joiner.add(String.valueOf(i));
        }
        System.out.println(joiner.toString());
    }
}
