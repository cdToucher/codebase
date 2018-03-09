import java.util.Arrays;

/**
 * Created by chendong on 2017/7/24.
 */
public class Test {


    static int[] arr = {1, 4, 2, 5, 9, 0, 6, 3, 7, 8};

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort(0, arr.length - 1, arr);
    }

    private static void sort(int low, int high, int[] arr) {
        if (low < high) {
            int foo = sorts(low, high, arr);
            sort(low, foo - 1, arr);
            sort(foo + 1, high, arr);
        }
    }

    private static int sorts(int low, int high, int[] arr) {
        int foo = (low + high) / 2;
        swap(foo, high, arr);
        int temp = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < arr[high]) {
                swap(temp, i, arr);  //?
                temp++;
            }
        }
        swap(temp, high, arr);
        return temp;
    }

    private static void swap(int i, int j, int[] arr) {
        int foo = arr[i];
        arr[i] = arr[j];
        arr[j] = foo;
    }
}
