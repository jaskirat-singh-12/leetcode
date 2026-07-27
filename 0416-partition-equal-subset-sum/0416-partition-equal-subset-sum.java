class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum %2 != 0) return false;

        int[][] dp = new int[nums.length][sum/2+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return partition(nums, 0, sum/2, dp);
    }
    public boolean partition(int[] nums, int i, int target, int[][] dp) {

        if(target < 0) return false;
        
        if(i == nums.length) {
            if(target == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        if(dp[i][target] != -1) {
            return dp[i][target] == 1 ? true : false;
        }

        boolean take = partition(nums, i+1, target - nums[i], dp);
        boolean skip = partition(nums, i+1, target, dp);
        dp[i][target] = take || skip ? 1 : 0;
        return take || skip;
    }
}