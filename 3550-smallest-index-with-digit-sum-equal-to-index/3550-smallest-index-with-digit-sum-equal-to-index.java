class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int sum = findSum(nums[i]);
            if(sum == i) {
                return i;
            }
        }
        return -1;
    }
    public int findSum(int n) {
        int ans = 0;

        while(n > 0) {
            ans += n % 10;
            n = n/10;
        }
        return ans;
    }
}