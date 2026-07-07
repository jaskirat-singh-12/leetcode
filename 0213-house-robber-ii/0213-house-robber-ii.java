class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int take1 = rob(nums, 0, n-2, dp);
        Arrays.fill(dp, -1);
        int take2 = rob(nums, 1, n-1, dp);
        return Math.max(take1, take2);
    }

    public int rob(int[] nums, int i, int n, int[] dp) {
        if(i > n) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        int take = nums[i] + rob(nums, i+2, n, dp);
        int skip = rob(nums, i+1, n, dp);

        return dp[i] = Math.max(take, skip);
    }
}

