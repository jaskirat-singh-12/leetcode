class Solution {
    public boolean isMatch(String txt, String pat) {
        int[][] dp = new int[txt.length()][pat.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return wildCard(txt, pat, 0, 0, dp);
    }
    public boolean wildCard(String txt, String pat, int i, int j, int[][] dp) {
        if(i >= txt.length() && j >= pat.length()) {
            return true;
        }
        
        if(j >= pat.length()) {
            return false;
        }
        
        if(i == txt.length()) {
            while(j < pat.length()) {
                if(pat.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }
        
        if(dp[i][j] != -1) return dp[i][j] == 1;
        
        if(pat.charAt(j) == '?') {
            dp[i][j] = wildCard(txt, pat, i+1, j+1, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }
        if(pat.charAt(j) == '*') {
             dp[i][j] = (wildCard(txt, pat, i+1, j, dp) || wildCard(txt, pat, i, j+1, dp)) ? 1 : 0;
             return dp[i][j] == 1;
        }
        
        if(pat.charAt(j) != txt.charAt(i)) dp[i][j] = 0;
        
        if(pat.charAt(j) != txt.charAt(i)) return false;
        
        dp[i][j] = wildCard(txt, pat, i+1, j+1, dp) ? 1 : 0;
        
        return dp[i][j] == 1;
    }
}