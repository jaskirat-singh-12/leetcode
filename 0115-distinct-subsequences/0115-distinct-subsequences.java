class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return distinct(s,t, 0, 0, dp);
    }

    public int distinct(String s, String t, int i, int j, int[][] dp) {
        if(i >= s.length()) {
            if(j >= t.length()) {
                return 1;
            }
            return 0;
        }
        if(j >= t.length()){
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int take = 0, skip = 0;

        if(s.charAt(i) == t.charAt(j)) {
            take = distinct(s,t,i+1,j+1, dp);
        }
        skip = distinct(s,t,i+1,j, dp);

        return dp[i][j] = skip + take;
    }
}