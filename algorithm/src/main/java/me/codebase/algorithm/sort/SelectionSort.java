package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/4/27.
 * <p>
 * select sort
 * <p>
 * O(n*n)
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, i, findMin(i));
        }
    }

    private int findMin(int j) {
        int index = j;
        int a = arr[j];
        for (; j < arr.length - 1; j++) {
            if (a > arr[j + 1]) {
                a = arr[j + 1];
                index = j + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
