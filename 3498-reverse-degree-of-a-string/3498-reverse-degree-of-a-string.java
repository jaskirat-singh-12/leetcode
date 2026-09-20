class Solution {
    public int reverseDegree(String s) {
        int idx = 1;
        int ans = 0;
        

        for(int i = 0; i < s.length(); i++) {
            int val = (int) s.charAt(i)- 'a' + 1;

            val = (26+val) - 2*val;

            ans += idx * (val+1);
            idx++;
        }
        return ans;
    }
}