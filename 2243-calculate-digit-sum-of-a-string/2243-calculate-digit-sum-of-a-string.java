class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k) {
            s = find(s,k);
        }
        return s;
    }
    public String find(String s, int k) {
        if(s.length() <= k) return s;
        StringBuilder st = new StringBuilder();

        int i = 0;

        while(i < s.length()) {
            int sum = 0;

            for(int j = i; j < Math.min(i + k, s.length()); j++) {
                sum += s.charAt(j) - '0';
            }

            st.append(sum);
            i += k;
        }
        return st.toString();
    }
}
