class Solution {
    int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {
        int[][][] dp = new int[nums.length][201][201];

        for(int[][] rows : dp) {
            for(int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        int[][] g = new int[201][201];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                g[i][j] = gcd(i, j);
            }
        }

        return subsequencePairCount(nums, 0, 0, 0, dp, g);
    }

    public int subsequencePairCount(int[] nums, int i, int gcd1, int gcd2, int[][][] dp, int[][] g) {
        if(i >= nums.length) {
            return (gcd1 == gcd2 && gcd1 != 0) ? 1 : 0;
        }
        
        if(dp[i][gcd1][gcd2] != -1) return dp[i][gcd1][gcd2];

        long take1 = 0, take2 = 0, skip = 0;

        skip = subsequencePairCount(nums, i+1, gcd1, gcd2, dp, g);

        take1 += subsequencePairCount(nums, i+1, g[gcd1][nums[i]], gcd2, dp, g);
        take2 += subsequencePairCount(nums, i+1, gcd1, g[gcd2][nums[i]], dp, g);
        return dp[i][gcd1][gcd2] =(int) ((take1 + take2 + skip) % MOD);
    }
    public int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}