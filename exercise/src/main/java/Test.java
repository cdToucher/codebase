import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by chendong on 2017/7/24.
 */
public class Test {


    static int[] arr = {2, 7, 8, 9, 3, 5, 6, 0, 1, 4};

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

    public static void main(String[] args) throws Exception {
        test1();
    }

}
