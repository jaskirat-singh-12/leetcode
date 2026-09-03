class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestNo = nums1[0];
        int even = 0;
        int n = nums1.length;
        
        for(int i = 0; i < n; i++) {
            smallestNo = Math.min(nums1[i], smallestNo);
            if(nums1[i] % 2 == 0) even++;
        }

        if(smallestNo % 2 != 0) return true;
        return even == n;
    }
}