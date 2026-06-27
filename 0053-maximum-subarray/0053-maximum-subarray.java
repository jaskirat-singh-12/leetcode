class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, curr = 0;

        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            max = Math.max(max, curr);
            curr = curr < 0 ? 0 : curr;
        }
        return max;
    }
}