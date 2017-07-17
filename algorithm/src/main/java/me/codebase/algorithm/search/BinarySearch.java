package me.codebase.algorithm.search;

/**
 * Created by chendong on 2017/5/11.
 */
public class BinarySearch implements Search {

    @Override
    public void search(int[] arr, int aim) {
        search1(arr, aim);
    }

    private void search2(int[] arr, int aim) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (aim == arr[middle]) {
                gotIt(middle);
                return;
            } else if (aim > arr[middle])
                low = middle + 1;
            else
                high = middle - 1;
        }
    }

    private void search1(int[] arr, int aim) {
        search(arr, -1, arr.length, aim);
    }

    private void search(int[] arr, int low, int high, int aim) {
        int middle = (low + high) / 2;
        if (low < high - 1) {
            if (aim == arr[middle])
                gotIt(middle);
            else if (aim > arr[middle])
                search(arr, middle, high, aim);
            else
                search(arr, low, middle, aim);
        }
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        search.search(orderedArr, 0);
        search.search(orderedArr, 1);
        search.search(orderedArr, 2);
        search.search(orderedArr, 3);
        search.search(orderedArr, 4);
        search.search(orderedArr, 5);
        search.search(orderedArr, 6);
        search.search(orderedArr, 7);
        search.search(orderedArr, 8);
        search.search(orderedArr, 9);
        search.search(orderedArr, 10);
    }
}
