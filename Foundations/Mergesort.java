import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 44, 2424, 44, 1337, 987, 1, 33, 2};
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergesort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int[] temp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + ((hi - lo) / 2);
        mergesort(arr, temp, lo, mid);
        mergesort(arr, temp, mid + 1, hi);
        merge(arr, temp, lo, mid, hi);
    }

    public static void merge(int[] arr, int[] temp, int lo, int mid, int hi) {
        int len = hi - lo + 1;
        int leftStart = lo;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = hi;
        int pos = lo;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                temp[pos] = arr[leftStart];
                leftStart++;
                pos++;
            } else {
                temp[pos] = arr[rightStart];
                rightStart++;
                pos++;
            }
        }

        while (leftStart <= leftEnd) {
            temp[pos] = arr[leftStart];
            leftStart++;
            pos++;
        }

        while (rightStart <= rightEnd) {
            temp[pos] = arr[rightStart];
            rightStart++;
            pos++;
        }

        for (int i = 0; i < len; i++, rightEnd--) {
            arr[rightEnd] = temp[rightEnd];
        }
    }
}
