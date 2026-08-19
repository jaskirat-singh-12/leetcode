class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int[] row : dp) Arrays.fill(row,-1);

        int ans = stoneGame(piles, 0, piles.length-1, dp);
        if(ans < 0) return false;
        return true;
    }

    public int stoneGame(int[] stone, int i, int j, int[][] dp) {
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        int takeFirst = stone[i] - stoneGame(stone, i+1, j, dp);
        int takeLast = stone[j] - stoneGame(stone, i, j-1, dp);
        return dp[i][j] = Math.max(takeFirst, takeLast);
    }
}