class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][2][piles.length*2];
        for(int[][] rows : dp) {
            for(int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return stoneGame(piles, 0, true, 1, dp);
    }

    public int stoneGame(int[] piles, int i, boolean isAlice, int m, int[][][] dp) {

        if(i >= piles.length) return 0;
        int res = 0;
        int alice = 0;
        if(isAlice) {
            res = -1;
            alice = 1;
        }
        else {
            res = Integer.MAX_VALUE;
            alice = 0;
        }

        int stone = 0;
        if(dp[i][alice][m] != -1) return dp[i][alice][m];

        for(int t = 1; t <= Math.min(2*m, piles.length - i); t++){
            stone += piles[i+t-1];
            if(isAlice) res = Math.max(res, stone + stoneGame(piles, i+t, !isAlice, Math.max(m, t), dp));

            else {
                res = Math.min(res, stoneGame(piles, i+t, !isAlice, Math.max(m, t), dp));
            }
        }
        return dp[i][alice][m] = res;

    }
}