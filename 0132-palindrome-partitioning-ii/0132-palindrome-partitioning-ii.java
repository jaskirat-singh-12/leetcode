class Solution {
    public int minCut(String s) {
        if(isPalindrom(s,0,s.length() -1)) return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return findCut(s,0,s.length() -1, dp);

    }

    public int findCut(String s, int i, int j, int[] dp) {
        if(i > j) return 0;
        
        if(isPalindrom(s, i, j)) return 0;

        if(dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++) {
            if(isPalindrom(s, i, k)) {
                ans = Math.min(1 + findCut(s, k+1,j, dp), ans);
            }
        }
        return dp[i] = ans;
    }

    public boolean isPalindrom(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}