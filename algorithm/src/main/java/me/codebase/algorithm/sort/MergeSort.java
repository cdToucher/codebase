package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/5/11.
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int helper[] = arr.clone();
        sort(arr, 0, arr.length - 1, helper);
    }


    private static void sort(int[] a, int lo, int hi, int[] helper) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid, helper);
        sort(a, mid + 1, hi, helper);
        merge(a, lo, mid, hi, helper);
    }

    private static void merge(int[] a, int lo, int mid, int hi, int[] helper) {
        System.arraycopy(a, lo, helper, lo, hi + 1 - lo);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = helper[j++];
            else if (j > hi)
                a[k] = helper[i++];
            else if (helper[i] <= helper[j])
                a[k] = helper[i++];
            else
                a[k] = helper[j++];
        }

    }

    public static void main(String[] args) {
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
