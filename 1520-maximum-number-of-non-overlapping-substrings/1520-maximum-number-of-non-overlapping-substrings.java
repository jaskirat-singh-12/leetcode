class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = (int)( ch - 'a');
            if(start[idx] == -1) {
                start[idx] = i;
            }
            end[idx] = i;
        }
        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);

        for(int i = 0; i < 26; i++) {
            if(start[i] == -1) continue;

            for(int j = start[i]; j <= end[i]; j++) {
                int idx = s.charAt(j) - 'a';

                if(start[idx] < start[i]) {
                    isValid[i] = false;
                    break;
                }
                end[i] = Math.max(end[idx], end[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        int last = Integer.MAX_VALUE;

        for(int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if(!isValid[idx]) {
                continue;
            }
            if(i == start[idx] && end[idx] < last) {
                ans.add(s.substring(i, end[idx]+1));
                last = i; 
            }
        }
        return ans;
    }
}