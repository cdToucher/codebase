package me.codebase.algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chendong on 2017/9/19.
 */
public class RadixSort implements Sort {

    @Override
    public void sort(int[] arr) {

        // 正数排序
        Stack<Integer>[] buckets = new Stack[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Stack<>();
        }
        // 创建10个桶
        int max = 0;
        for (int a : arr) {
            max = max > a ? max : a;
        }
        int decimal = String.valueOf(max).toCharArray().length; // 确定最高位

        for (int i = 0; i < decimal; i++) {
            for (int a : arr) {
                //获取某位的数值
                char[] chars = String.valueOf(a).toCharArray();

                int val = Character.digit(chars[i], 10);
                buckets[val].push(a);
            }
            //重新放回 数组
            int j = 0;
            for (Stack<Integer> bucket : buckets) {
                while (!bucket.empty()) {
                    arr[j] = bucket.pop();
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new RadixSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
