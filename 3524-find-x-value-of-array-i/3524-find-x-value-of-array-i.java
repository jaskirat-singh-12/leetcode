class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] ans = new long[k];
        long[] prev = new long[k];

        for(int i = 0; i < n; i++) {
            long[] curr = new long[k];
            int cur = nums[i] % k;
            curr[cur]++;

            for(int j = 0; j <= k-1; j++) {
                int currRem =(int) (((long) j * nums[i] % k) % k);

                curr[currRem] += prev[j];
            }
            prev = curr;

            for(int rem = 0; rem < k; rem++) {
                ans[rem] += prev[rem];
            }
        }
        return ans;
    }
}