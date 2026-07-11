class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];

        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxAlternatingSum(nums, 0, true, dp);
    }

    public long maxAlternatingSum(int[] nums, int i, boolean isEven, long[][] dp) {
        if(i >= nums.length) {
            return 0;
        }
        int evenVal = isEven ? 1 : 0;

        if(dp[i][evenVal] != -1) return dp[i][evenVal];

        long take = 0, skip = 0;

        skip = maxAlternatingSum(nums, i+1, isEven, dp);

        long val = nums[i];

        if(!isEven) {
            val = -val; // 5 => -5
        }

        take = maxAlternatingSum(nums, i+1, !isEven, dp) + val; // -5

        return dp[i][evenVal] = Math.max(take, skip);
    }
}