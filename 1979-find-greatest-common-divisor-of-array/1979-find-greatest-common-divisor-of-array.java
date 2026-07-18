class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = 0;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if(min == max) return min;

        int i = min;

        while(i > 0) {
            if(min % i == 0 && max % i == 0){
                return i;
            }
            i--;
        }
        return i;
    }
}