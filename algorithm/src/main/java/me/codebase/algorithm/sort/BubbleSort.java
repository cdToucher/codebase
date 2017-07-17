package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/4/27.
 * <p>
 * bubble
 * <p>
 * O(n*n)
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }


    public static void main(String[] args) {
        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
