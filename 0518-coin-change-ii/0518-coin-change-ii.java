class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return change(amount, coins, 0, dp);
    }

    public int change(int target, int[] coins, int i, int[][] dp) {
        if(target == 0) return dp[target][i] = 1;
        if(i == coins.length) return 0;
        if(dp[target][i] != -1) return dp[target][i];

        int take = 0, skip = 0;
        if(target >= coins[i]) {
            take += change(target - coins[i], coins, i, dp);
        }
        skip += change(target, coins, i+1, dp);
        return dp[target][i] = take + skip;
    }
}