class Solution {
    public int totalNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(i == j || j==k || k==i){
                        continue;
                    }
                    int val = nums[i] * 100 + nums[j] * 10 + nums[k];

                    if(val % 2 == 0 && val > 99 && val < 1000) set.add(val);
                }
            }
        }
        return set.size();
    }


}