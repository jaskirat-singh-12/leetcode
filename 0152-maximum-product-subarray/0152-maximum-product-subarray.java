class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0];
        int ans = max;

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = curr * max;
            int tempMin = curr * min;
            max = Math.max(curr, Math.max(tempMax, tempMin));
            min = Math.min(curr, Math.min(tempMax, tempMin));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}