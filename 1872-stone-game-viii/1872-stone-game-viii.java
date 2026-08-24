class Solution {
    public int stoneGameVIII(int[] stones) {
        int[] prefix = new int[stones.length];
        int[] dp = new int[stones.length];
        Arrays.fill(dp,-1);

        prefix[0] = stones[0];
        for(int i = 1; i < stones.length; i++) {
            prefix[i]= stones[i] + prefix[i-1];
        }
        dp[stones.length-1] = prefix[prefix.length-1];
        int take = 0, skip = 0;
        
        for(int i = stones.length-2; i >=1; i--) {
            take = prefix[i] - dp[i+1];
            skip = dp[i+1];
            dp[i] = Math.max(take, skip);
        }
        return dp[1];
    }

    // public int stone(int i, int[] pre, int[] dp) {
    //     if(i >= pre.length-1) return pre[pre.length-1];
    //     if(dp[i] != -1) return dp[i];

    //     int take = pre[i] - stone(i+1, pre, dp);

    //     int skip = stone(i+1, pre, dp);
        
    //     return dp[i] = Math.max(take, skip);
    // }
}