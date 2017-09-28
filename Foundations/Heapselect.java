import java.util.Arrays;

public class Heapselect {

    final static int UNUSED = -1;

    public static void main(String[] args) {
        int[] arr = new int[]{UNUSED, 1, 2, 2, 2, 100, 32, 2424, 1999, 13, 4, 100, 9991};
        // Find K largest
        int k = 1;
        // Max heap
        int ans = heapselect(arr, k);
        System.out.println(k + "-th is " + ans);
    }

    // Heapselect is basically an incomplete heapsort
    // Instead of sorting the whole thing, it justs sorts
    // up to K. This is the largest.
    public static int heapselect(int[] arr, int k) {

        // Heapify
        int lastParent = arr.length / 2;
        for (int i = lastParent; i >= 1; i--) {
            sink(arr, i, arr.length);
        }
        // Heapsort up to k
        for (int i = 1; i < k; i++) {
            swap(arr, 1, arr.length - i);
            sink(arr, 1, arr.length - 1 - i);
        }

        return arr[1];


    }

    public static void sink(int[] arr, int pos, int len) {
        int leftChild = pos*2;
        if (leftChild > len) return;
        int rightChild = leftChild + 1;

        int maxChild = (rightChild >= len) ? leftChild : (arr[rightChild] > arr[leftChild]) ? rightChild : leftChild;

        // If pos is max, no sink is needed as it has found its place
        if (arr[pos] > arr[maxChild]) return;

        swap(arr, pos, maxChild);
        sink(arr, maxChild, len);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
