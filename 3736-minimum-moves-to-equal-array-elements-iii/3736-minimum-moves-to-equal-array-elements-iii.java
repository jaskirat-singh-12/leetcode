class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int ans = 0;

        for(int num : nums) {
            ans += max - num;
        }
        return ans;
    }
}