class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int[] unique = RemoveDuplicate(nums);
        
        for(int i = 0; i < unique.length; i++) {
            int start = unique[i];
            int end = start + n - 1;
            int j = binarySearch(i, end, unique);
            int inRange = j - i + 1;
            int outRange = n - inRange;

            min = Math.min(min, outRange);
        }
        return min;

    }
    public int binarySearch(int i, int target, int[] nums) {
        int low = i, high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] > target) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return high;
    }

    public int[] RemoveDuplicate(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                arr.add(nums[i]);
            }
            set.add(nums[i]);
        }
        int[] ans = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}