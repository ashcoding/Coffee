public class Quickselect {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 242, 89, 24, 100, 1, 1, 1337};
        int k = 3;
        int result = quickselect(arr, k);
        System.out.println(k + "-th is " + result);
    }

    public static int quickselect(int[] arr, int n) {
        int lo = 0, hi = arr.length - 1;
        int k = arr.length - n;
        // k largest

        //int k = n - 1;
        // k smallest

        while (true) {
            int pivot = partition(arr, lo, hi);
            if (pivot < k) lo = pivot + 1;
            else if (pivot > k) hi = pivot - 1;
            else return arr[pivot];
        }
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
