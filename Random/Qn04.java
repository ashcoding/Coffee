import java.util.Arrays;

public class Qn04 {
    public static void main(String[] args) {
        int steps = 9;
        int ways = countWays(steps);
        System.out.println(steps + " steps has " + ways + " ways");
    }

    public static int countWays(int steps) {
        int[] memo = new int[steps + 1];
        Arrays.fill(memo, -1);
        return countWays(steps, memo);
    }

    public static int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] > -1 ) return memo[n];

        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo)
            + countWays(n - 3, memo);
        return memo[n];
    }
}
// Qn 8.1
// A child is running up the stairs with n steps.
// Child can hop 1, 2 or 3 steps. How many ways are there?
