class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }

        HashSet<String> set = new HashSet<>();
        for(String st : wordDict) {
            set.add(st);
        }

        return wordbreak(s, 0, 1, set, dp);

    }
    public boolean wordbreak(String s, int i, int len, HashSet<String> set, int[][] dp) {
        if(i >= s.length()) return true;

        if(i+len-1 >= s.length()) {
            return false;
        }

        if(dp[i][len] != -1) return dp[i][len] == 0 ? false : true;
        String word = s.substring(i, i+len);

        if(set.contains(word)) {
            boolean ans = (wordbreak(s, i+len, 1 , set, dp) || wordbreak(s, i, len+1 , set, dp));
            dp[i][len] = ans ? 1 : 0;
            return ans;
        }
        boolean ans = wordbreak(s, i, len+1 , set, dp);
        dp[i][len] = ans ? 1 : 0;
        return ans;
    }
}