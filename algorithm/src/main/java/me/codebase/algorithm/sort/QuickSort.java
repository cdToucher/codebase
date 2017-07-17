package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/4/27.
 * <p>
 * pivot 基准
 * <p>
 * partition 分区
 * <p>
 * 递归
 * <p>
 * 在实际情况中 根据数据可选择合适的 基准 以提高排序速度
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) { // 分片递归
        if (low >= high) return; // 终止条件
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    //精髓在这里？！ 找到 分隔下标
    private int partition(int[] arr, int low, int high) {
        int pivot = (low + high) / 2;
        swap(arr, high, pivot);  // 将 基准值放在最后
        int index = low;
        for (int i = low; i < high ; i++) {
            if (arr[i] < arr[high]) {
                swap(arr, i, index);  // 将比基准值小的数放在左侧
                index++; // 比基准值小的个数 对应+1
            }
        }
        swap(arr, index, high);  // 将 基准值 放在对应的下标位
        return index; //返回 下标位
    }

    public static void main(String[] args) {
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
