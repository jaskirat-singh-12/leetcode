class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int[] row : dp) Arrays.fill(row, -1);

        int total = 0;
        for(int num : nums) {
            total += num;
        }

        int pl1 = findSum(nums, 0, nums.length-1, dp);

        int pl2 = total - pl1;
        return pl1 >= pl2;
    }

    public int findSum(int[] nums, int i, int j, int[][] dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int take_i = nums[i] + Math.min(findSum(nums, i+2, j, dp), findSum(nums, i+1, j-1, dp));
        int take_j = nums[j] + Math.min(findSum(nums, i, j-2, dp), findSum(nums, i+1, j-1, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }
}