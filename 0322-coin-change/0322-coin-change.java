class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        int ans = coinChange(coins, amount, 0, dp);

        return ans >= 1000000000 ? -1 : ans;
    }
    public int coinChange(int[] coins, int target, int i, int[][] dp) {
        if(i == coins.length || target == 0){
            if(target == 0) {
                if(i < coins.length) dp[i][target] = 0;
                return 0;
            }
            else {
                return 1000000000;
            }
        }
        if(dp[i][target] != -1) return dp[i][target];

        int take = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        if(coins[i] <= target) {
            take = 1 + coinChange(coins, target - coins[i], i, dp);
        }
        
        skip = coinChange(coins, target, i+1, dp);

        return dp[i][target] = Math.min(take, skip);
    }
}