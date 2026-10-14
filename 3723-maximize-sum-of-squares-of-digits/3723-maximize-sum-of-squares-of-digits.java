class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        
        for(int i = 1; i <= num; i++) {
            int digit = Math.min(9, sum);
            ans.append((char)(digit + '0'));
            sum -= digit;
        }
        if(sum != 0) return "";

        return ans.toString();
    }
}