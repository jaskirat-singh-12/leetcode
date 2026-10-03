class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int open = 0;
        int close = 0;


        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            }
            else {
                close++;
            }

            if(open == close){
                ans = Math.max(ans, open + close);
            }
            if(close > open) {
                close = 0;
                open = 0;
            }
        }
        
        open = 0;
        close = 0;


        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ')') {
                close++;
            }
            else {
                open++;
            }

            if(open == close){
                ans = Math.max(ans, open + close);
            }
            if(close < open) {
                close = 0;
                open = 0;
            }
        }
        return ans;
    }   
}