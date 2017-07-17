package me.codebase.algorithm;

/**
 * Created by chendong on 2017/4/27.
 * <p>
 * base algos
 */
public interface Base {

    int[] arr = {0, 2, 4, 6, 8, 5, 3, 7, 9, 1};
    int[] orderedArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    default void gotIt(int index){
        System.out.println(index);
    }
}
