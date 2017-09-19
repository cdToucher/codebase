package me.codebase.algorithm.sort;

import java.util.Arrays;

/**
 * Created by chendong on 2017/9/19.
 */
public class CountSort implements Sort {

    @Override
    /**
     * O(3n+max) -> O(n)
     */
    public void sort(int[] arr) {
        int max = 0;
        for (int anArr : arr) {
            max = anArr > max ? anArr : max;
        }
        int[] count = new int[max + 1];
        for (int anArr : arr) {
            count[anArr]++;
        }

        for (int i = 0, j = 0; i < count.length; i++) {
            for (int k = 0; k < count[i]; k++) {
                arr[j] = i;
                j++;
            }
        }

        //注释里是另一种思路，先将获得count数组在arr中的index，再将数据存入arr
/*        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sorted = new int[arr.length];
        for (int anArr : arr) {
            int index = count[anArr];
            sorted[index - 1] = anArr;
            count[anArr]--;
        }
        System.out.println(Arrays.toString(sorted));*/

    }

    public static void main(String[] args) {
        new CountSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
