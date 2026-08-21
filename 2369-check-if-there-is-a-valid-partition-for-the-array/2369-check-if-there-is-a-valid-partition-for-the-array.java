class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return valid(nums, 0, dp);
    }

    public boolean valid(int[] nums, int i, int[] dp) {
        if(i >= nums.length) return true;
        if(dp[i] != -1) return dp[i] == 0 ? false : true;

        for(int size = 2; size <= 3; size++) {
            if(check(nums,i, size)) {
                if(valid(nums, i+size, dp)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;

    }
    public boolean check(int[] nums, int i, int size) {
        if(i + size-1 >= nums.length) return false;

        if(size == 2) {
            if(nums[i] == nums[i+1]) return true;
            else return false;
        }
        return (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
            || (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]);
    }
}