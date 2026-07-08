class Solution {
    long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        dp = new long[100001][2];
        for (long[] row : dp) {

            Arrays.fill(row, -1);
        }

        return alternatingSum(0, nums, true);
    }

    public long alternatingSum(int idx, int[] nums, boolean isEven) {

        if (idx >= nums.length) {
            return 0;
        }
        int dp_val = isEven ? 0 : 1;

        if (dp[idx][dp_val] != -1) {
            return dp[idx][dp_val];
        }

        long skip = alternatingSum(idx + 1, nums, isEven);

        long val = nums[idx];

        if (isEven == false) {
            val = -val;
        }
        long taken = alternatingSum(idx + 1, nums, !isEven) + val;

        return dp[idx][dp_val] = Math.max(taken, skip);
    }

}