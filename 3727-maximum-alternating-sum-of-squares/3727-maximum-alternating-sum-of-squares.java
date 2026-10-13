class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        int count = 0;
        long ans = 0;
        if(n % 2 == 0) count = 1;

        while(count <= n/2) {
            if(nums[i] * nums[i] > nums[j] * nums[j]) {
                ans += nums[i] * nums[i];
                i++;
            }
            else{
                ans += nums[j] * nums[j];
                j--;
            }
            count++;
        }
        long total = 0;

        for(int k = 0; k < n; k++) {
            total += nums[k] * nums[k];
        }

        long rem = total - ans;
        return ans - rem;
    }
}