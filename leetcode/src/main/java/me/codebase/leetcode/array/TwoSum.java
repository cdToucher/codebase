package me.codebase.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chendong on 2017/11/2.
 */
public class TwoSum {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 6, 7,};
        int target = 9;
        System.out.println(Arrays.toString(solution2(arr, target)));
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

    static int[] solution2(Integer[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int rest = target - arr[i];
            if (map.containsKey(rest)) {
                return new int[]{map.get(rest), i};
            }
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
