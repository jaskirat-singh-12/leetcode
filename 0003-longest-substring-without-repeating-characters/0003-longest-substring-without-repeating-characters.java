class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 1) {
                    while(map.get(ch) > 1) {
                        char cha = s.charAt(i);
                        map.put(cha, map.get(cha) - 1);
                        i++;
                    }
                }
            }
            ans = Math.max(ans, j - i +1);
            j++;
        }
        return ans;
    }
}