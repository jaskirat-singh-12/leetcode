class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        Arrays.fill(dp, -1);
        int take_0 = finalRobbing(nums, 0, nums.length - 2);
        Arrays.fill(dp, -1);
        int take_1 = finalRobbing(nums, 1, nums.length-1);
        return Math.max(take_1, take_0);
    }

    public int finalRobbing(int[] nums, int i, int n){
        if(i > n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int steal = nums[i] + finalRobbing(nums, i+2, n);
        int skip = finalRobbing(nums, i+1, n);

        return dp[i] = Math.max(steal, skip);
    }
}