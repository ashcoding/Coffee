public class Qn01 {
    public static void main(String[] args) {
        int target = 15;
        int[] arr = {1, 3, 4, 5, 6, 15};

        countsubsets(arr, target);
    }
    // Trying to understand this answer.... I don't get it too well...
    public static void countsubsets(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[sum+1][n+1];

        for(int i = 1; i <= sum; i++){
            for(int j = 1; j <= n; j++){
                if(i > arr[j-1])
                    dp[i][j] = dp[i-arr[j-1]][j-1];
                else
                    dp[i][j] = dp[i][j-1];

                if(arr[j-1] == i)
                    dp[i][j] += 1;
            }
        }
        System.out.println("DP soln - ");
        System.out.println("count - " + dp[sum][n]);
        System.out.println();
        for(int i = 0; i < dp.length ; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
    }
}

// https://www.careercup.com/question?id=5724941042319360
