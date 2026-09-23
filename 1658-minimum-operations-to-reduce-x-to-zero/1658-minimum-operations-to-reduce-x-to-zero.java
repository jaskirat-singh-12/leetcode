class Solution {
    boolean finalAns = false;

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        map.put((long) 0, -1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        
        long t = sum - x;
        long max = -1;
        sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            long remaining = sum - t;

            if(map.containsKey(remaining)) {
                max = Math.max(max, i - map.get(remaining));
            }
            
        }
        int ans = (int) max;

        return ans == -1 ? -1 : n- ans;
    }
}