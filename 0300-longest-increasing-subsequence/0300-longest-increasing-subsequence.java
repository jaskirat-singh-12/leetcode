class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lengthOfLIS(nums, 0, -1, dp);
    }

    public int lengthOfLIS(int[] nums, int i, int j, int[][] dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(j != -1 && dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0, skip = 0;

        if(j == -1 || nums[j] < nums[i]) {
            take = 1 + lengthOfLIS(nums, i+1, i, dp);
        }
        skip = lengthOfLIS(nums, i+1, j, dp);
        
        if(j > -1) {
            dp[i][j] = Math.max(take, skip);
        }
        return Math.max(take, skip);

    }
}