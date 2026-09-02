class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        // int[] odd = new int[n];
        // int[] even = new int[n];
        boolean oddFalse = false;
        boolean evenFalse = false;

        for(int i = 0; i < n; i++) {
            boolean isodd = false;

            if(nums1[i] % 2 != 0){
                // odd[i] = nums1[i];
                isodd = true;
            }
            else{
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;

                    if((nums1[i] - nums1[j]) % 2 != 0) {
                        // odd[i] = nums1[i] - nums1[j];
                        isodd = true;
                    }
                }
            }
            if(isodd == false) {
                oddFalse = true;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            boolean iseven = false;

            if(nums1[i] % 2 == 0){
                // even[i] = nums1[i];
                iseven = true;
            }
            else{
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;

                    if((nums1[i] - nums1[j]) % 2 == 0) {
                        // even[i] = nums1[i] - nums1[j];
                        iseven = true;
                    }
                }
            }
            if(iseven == false) {
                evenFalse = true;
                break;
            }
        }
        if(!oddFalse || !evenFalse){
            return true;
        }
        return false;
    }
}