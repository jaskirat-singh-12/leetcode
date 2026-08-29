class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);

        return decode(s, 0, dp);
    }

    public int decode(String s, int i, int[] dp) {
        if(i == s.length()) return 1;
        if(i > s.length()) return 0;
        if(dp[i] != -1) return dp[i];

        int sum = 0;

        if (s.charAt(i) != '0') {
            sum += decode(s, i + 1, dp);
        }

        if( i < s.length()-1){
            int val = s.charAt(i+1) - '0';
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' &&  val <= 6 )){
                sum += decode(s, i+2, dp);
            }
        }
        return dp[i] = sum;
    }
}
