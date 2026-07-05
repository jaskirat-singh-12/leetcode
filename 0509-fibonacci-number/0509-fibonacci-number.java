class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fiboRecursion(n, dp);
    }

    public int fiboRecursion(int n, int[] dp) {
        if(n == 0 || n == 1) return dp[n] = n;

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fiboRecursion(n-1, dp) + fiboRecursion(n-2, dp);
    }
}