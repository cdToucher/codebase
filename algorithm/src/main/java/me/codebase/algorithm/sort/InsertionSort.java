package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/4/27.
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <i; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        new InsertionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
