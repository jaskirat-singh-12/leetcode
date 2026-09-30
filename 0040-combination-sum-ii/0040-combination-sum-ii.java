class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void combinationSum2(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int start) {
        if(0 == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(start >= nums.length) {
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            temp.add(nums[i]);
            combinationSum2(nums, target- nums[i], ans, temp, i+1);
            temp.remove(temp.size()-1);
        }

    }
}