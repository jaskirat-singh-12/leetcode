class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = -1, len = Integer.MAX_VALUE;

        if(k > s.length()) return "";

        int i = 0, j = 0;
        int count = 0;

        while(j < s.length()) {

            if(s.charAt(j) == '1') count++;
            

            while(count > k) {
                if(s.charAt(i) == '1') count--;
                i++;
            }

            if(count == k) {
                while (s.charAt(i) == '0') {
                    i++;
                }

                if(len > j-i+1) {
                    start = i;
                    len = j-i+1;
                }
                else if (j-i+1 == len) {

                    String current = s.substring(i, j + 1);
                    String previous = s.substring(start, start + len);

                    if (current.compareTo(previous) < 0) {
                        start = i;
                    }
                }
            }

            j++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }
}