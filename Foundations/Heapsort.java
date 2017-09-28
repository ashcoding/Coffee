import java.util.Arrays;

public class Heapsort {
    public static final int UNUSED = -1;

    public static void main(String[] args) {
        int[] arr = new int[]{UNUSED, 10, 123, 10, 42, 99, 1337, 9900, 1986};
        // arr[0] is unused to make counting easier. No off by one errors!
        System.out.println(Arrays.toString(arr));
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // This is a max heap
    public static void heapsort(int[] arr) {
        int len = arr.length;
        // Get into heap order. Start from last leaf
        for (int i = len/2; i >= 1; i--) {
            sink(arr, i, len);
        }

        // Sort now
        for (int i = 1; i < len; i++) {
            swap(arr, 1, len-i);
            sink(arr, 1, len-i-1);
        }
    }

    public static void sink(int[] arr, int pos, int len) {
        int leftChild = pos*2;
        if (leftChild > len) return;
        int rightChild = leftChild + 1;
        int maxChild = rightChild >= len ? leftChild : (arr[rightChild] > arr[leftChild]) ? rightChild : leftChild;

        if (arr[pos] > arr[maxChild]) return; // We are done

        // Swap the values
        swap(arr, pos, maxChild);

        // Sink from the new pos from the maxChild
        sink(arr, maxChild, len);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
