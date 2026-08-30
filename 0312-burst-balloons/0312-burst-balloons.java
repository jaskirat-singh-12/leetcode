class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length+2];
        num[0] = 1;
        num[num.length-1] = 1;
        int idx=1;
        int[][] dp = new int[num.length+1][num.length+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int n : nums) {
            num[idx++] = n;
        }
        return burst(num, 1, nums.length, dp);
    }

    public int burst(int[] nums, int i, int j, int[][] dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int sum = 0;
        for(int k = i; k <= j; k++) {
            int cost = 0;

            cost += (nums[i-1] * nums[k] * nums[j+1]) + burst(nums, i, k-1, dp) + burst(nums, k+1, j, dp);
            
            sum = Math.max(cost, sum);
        }
        return dp[i][j] = sum;
    }
}