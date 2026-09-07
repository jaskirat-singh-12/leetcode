class Solution {
    public int distinctSubseqII(String s) {
        long mod = 1000000007;

        long ans = 0;
        long[] dp = new long[26];

        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            long sub = (ans + 1) % mod;

            ans = (ans + sub - dp[idx] + mod) % mod;

            dp[idx] = sub;
        }
        return (int) ans;
    }
}