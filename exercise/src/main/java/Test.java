import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chendong on 2017/7/24.
 */
public class Test implements Serializable {


    static int[] arr = {2, 7, 8, 9, 3, 5, 6, 0, 1, 4};


    static class T {
        public List<String> getListIds() {
            return listIds;
        }

        public void setListIds(List<String> listIds) {
            this.listIds = listIds;
        }

        List<String> listIds = new ArrayList<>();
    }

    // a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        int a =
    }


    private static boolean ifIntersect(int[] arrA, int[] arrB) {
        if (arrA.length == 0 || arrB.length == 0)
            return false;
        else if (arrA.length <= 1 && arrB.length <= 1)
            return false;
        if (arrA[1] > arrB[0])
        return true;
        return false;
    }

    //最长上升子序集
    private static void LIS() {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18, 1077};
        // 0 <=n,m<arr.length  n<m
        // Max{f(n,m)}
        int max = 1;
        int maxArr[] = new int[arr.length];
        maxArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            maxArr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && maxArr[i] <= maxArr[j]) {
                    maxArr[i] = maxArr[j] + 1;
                }
            }
        }
        // find the max in the maxArr
        System.out.println(Arrays.toString(maxArr));
    }

    private static void swap(int i, int j, int[] arr) {
        int foo = arr[i];
        arr[i] = arr[j];
        arr[j] = foo;
    }

    private static void sort(int low, int high, int[] arr) {
        if (low < high) {
            int partition = getPartition(low, high, arr);
            sort(low, partition - 1, arr);
            sort(partition + 1, high, arr);
        }
    }

    private static int getPartition(int low, int high, int[] arr) {
        int middle = (low + high) / 2;
        int partition = low;
        swap(middle, high, arr);
        for (int i = low; i < high; i++) {
            if (arr[i] < arr[high]) {
                swap(i, partition, arr);
                partition++;
            }
        }
        swap(partition, high, arr);
        return partition;
    }

    static class P {
        public P(int num) {
            this.num = num;
        }

        private P next;
        private P pre;
        private int num;
    }

    private static boolean noRest(int num) {
        return num >= 3 && num % 3 == 0;
    }


    private static void test1() {
        List<P> persons = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            persons.add(new P(i));
        }
        for (int i = 0; i < 20; i++) {
            P p = persons.get(i);
            if (i == persons.size() - 1)
                p.next = persons.get(0);
            else
                p.next = persons.get(i + 1);
            if (i == 0)
                p.pre = persons.get(persons.size() - 1);
            else
                p.pre = persons.get(i - 1);
        }

        int num = 0;
        P p = persons.get(0);
        while (p.next != p) {
            if (num >= 3 && num % 3 == 0) {
                p.pre.next = p.next;
                p.next.pre = p.pre;
            }
            p = p.next;
            num++;
        }
        System.out.println(p.num);
    }


    static final int hash(Object key) {

        //        Collections.synchronizedMap()
        //与（&）、非（~）、或|、异或（^）

        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    private static void search(int search) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
/*            if (search == high) {
                System.out.println(high);
                break;
            }*/
            if (search < low || search > high) {
                break;
            }
            int mid = (low + high) / 2;
            if (arr[mid] == search) {
                System.out.println(mid);
                break;
            } else if (arr[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

}
