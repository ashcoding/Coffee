import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 12, 4, 23, 11, 1, 999, 134, 34, 23};
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partition(arr, lo, hi);
        quicksort(arr, lo, pivot);
        quicksort(arr, pivot + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j;

            swap(arr, i, j);

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
