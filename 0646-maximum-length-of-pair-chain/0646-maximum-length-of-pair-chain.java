class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] dp = new int[pairs.length][pairs.length];

        for(int[] row : dp) {
            Arrays.fill(row, -1);

        }

        return findLongestChain(pairs, 0, -1, dp);
    }

    public int findLongestChain(int[][] pairs, int i, int j, int[][] dp) {
        if(i >= pairs.length) {
            return 0;
        }

        if(j != -1 && dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0, skip = 0;

        if(j == -1 || pairs[j][1] < pairs[i][0]) {
            take = 1 + findLongestChain(pairs, i+1, i, dp);
        }
        skip = findLongestChain(pairs, i+1, j, dp);

        if(j != -1) dp[i][j] = Math.max(take, skip);

        return Math.max(take, skip);
    }
}