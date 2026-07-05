class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbRecur(n, dp);
    }
    
    public int climbRecur(int n, int[] dp) {
       
        if(0 == n) {
            return dp[n] = 1;
        }
        
        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbRecur(n-1, dp) + climbRecur(n-2, dp);
    }
}