class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int dis = 0;
                HashSet<Integer> set = new HashSet<>();
                for(int k = i; k <= j; k++) {
                    set.add(nums.get(k));
                }
                dis = set.size();
                ans += dis * dis;
            }
        }

        return ans;
    }
}