class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[1001][1001];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int max = 0;

        // for(int i = 1; i <= text1.length(); i++){
        //     for(int j = 1; j <= text2.length(); j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //                 dp[i][j] = 1 + dp[i-1][j-1];
        //         }    
        //         else{

        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
                
        //         max = Math.max(max, dp[i][j]);
        //     }
        // }
        return lcs(text1, text2, 0, 0, dp);

    }

    public int lcs(String a, String b, int i, int j, int[][] dp) {
        if(i >= a.length() || j >= b.length()) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)) {
            return 1 + lcs(a,b,i+1,j+1, dp);
        }

        int skip_a = lcs(a,b,i+1,j, dp);
        int skip_b = lcs(a,b,i,j+1, dp);

        return dp[i][j] = Math.max(skip_a, skip_b);
    }
}