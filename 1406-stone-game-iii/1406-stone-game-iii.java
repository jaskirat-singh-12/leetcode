class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int total = 0;
        for(int val : stoneValue) total += val;

        int alice = stoneGame(stoneValue, 0, dp);
        if (alice > 0) return "Alice";
        if (alice < 0) return "Bob";
        return "Tie";
    }
    public int stoneGame(int[] stone, int i, int[] dp) {
        if(i >= stone.length) return 0;
        int sum = 0, res = Integer.MIN_VALUE;
        if(dp[i] != -1) return dp[i];

        for(int t = 1; t <= 3 && i+t <= stone.length; t++) {
            sum += stone[i + t - 1];

            res = Math.max(res, sum - stoneGame( stone, i+t, dp));
        }
        return dp[i] = res;
    }
}