class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climb(0, n, dp);
    }

    public int climb(int i, int n, int[] dp) {
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != 0) return dp[i];

        return dp[i] = (climb(i+1, n, dp) + climb(i+2, n, dp));
    }
}