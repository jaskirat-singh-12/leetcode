class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];

        max[0] = nums[0];
        min[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1], nums[i]);
        }

        for(int i = n-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, max[i] - min[i]);
            if(ans <= k) return i;
        }
        return -1;
    }
}