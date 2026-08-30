class Solution {
    public int minCost(int n, int[] cuts) {
        int[] cut = new int[cuts.length+2];
        int idx = 0;
        int[][] dp = new int[cuts.length+1][cuts.length+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int c : cuts) {
            cut[idx++] = c;
        }
        cut[cut.length - 2] = 0;
        cut[cut.length - 1] = n;
        Arrays.sort(cut);

        return find(cut, 1, cut.length-2, dp);
    }

    public int find(int[] cut, int i, int j, int[][] dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++) {
            int cost = cut[j+1] - cut[i-1] + find(cut, i, k-1, dp) + find(cut, k+1, j, dp);

            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}