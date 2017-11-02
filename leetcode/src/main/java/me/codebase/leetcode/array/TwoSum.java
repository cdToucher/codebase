package me.codebase.leetcode.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chendong on 2017/11/2.
 */
public class TwoSum {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 6, 7,};
        int target = 9;
        System.out.println(Arrays.toString(solution(arr, target)));
    }

    static int[] solution(int[] arr, int target) {
        throw new IllegalArgumentException("No two sum solution");
    }


    static int[] solution(Integer[] arr, int target) {
        List<Integer> list = Arrays.asList(arr);
        for (int i : list) {
            int rest = target - i;
            if (list.contains(rest)) {
                return new int[]{list.indexOf(i), list.indexOf(rest)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
