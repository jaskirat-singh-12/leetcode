class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        if(nums.length % 2 != 0) {
            int mid = nums.length/2;

            ans = Math.min(ans, find(nums, nums[mid]));
        }
        else{
            int mid1 = nums.length/2;
            int one = find(nums, nums[mid1]);
            int two = find(nums, nums[mid1-1]);

            ans = Math.min(ans, Math.min(one, two));
        }
        return ans;
    }

    public int find(int[] nums, int mid) {
        int ans = 0;

        for(int i = 0; i < nums.length;i++) {
            if(nums[i] < mid) {
                ans += mid - nums[i];
            }
            else{
                ans += nums[i] - mid;
            }
        }
        return ans;
    }
}