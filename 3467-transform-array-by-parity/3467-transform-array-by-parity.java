class Solution {
    public int[] transformArray(int[] nums) {
        int even = 0, odd = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {even++;}
            else {odd++;}
        }

        for(int i = 0; i < n; i++) {
            if(even > 0) {
                nums[i] = 0;
                even--;
            }
            else if(odd > 0) {
                nums[i] = 1;
                odd--;
            }
        }
        return nums;
    }
}