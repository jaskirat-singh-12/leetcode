class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSumWays(nums, target, 0);
    }
    public int targetSumWays(int[] nums, int target, int i) {
        if(i == nums.length) {
            if(target == 0){
                return 1;
            }
            return 0;
        }

        int takePlus = targetSumWays(nums, target + nums[i], i+1);
        int takeNeg = targetSumWays(nums, target - nums[i], i+1);

        return takePlus + takeNeg;
    }
}