public class Qn05 {
    public static void main(String[] args) {
        int[] arr = new int[]{-40, -20, -1, 1, 2, 3, 4, 7, 9, 12, 13};
        int answer = magicFast(arr);
        System.out.println(answer);
    }

    public static int magicSlow(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    // Binary search
    public static int magicFast(int[] arr) {
        return magicFast(arr, 0, arr.length - 1);
    }

    public static int magicFast(int[] arr, int start, int end) {
        int mid = start + ((end - start) / 2);
        if (arr[mid] == mid) return mid;
        else if (arr[mid] < mid) return magicFast(arr, mid + 1, end);
        else return magicFast(arr, start, mid - 1);
    }
}
