class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findTarget(candidates, target, 0, ans, 0, new ArrayList<>());

        return ans;
    }
    public void findTarget(int[] nums, int target, int sum, List<List<Integer>> ans, int i, List<Integer> temp) {
        if(target == sum) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(i >= nums.length || sum > target) return;

        temp.add(nums[i]);
        findTarget(nums, target, sum + nums[i] , ans, i, temp);
        temp.remove(temp.size() - 1);
        findTarget(nums, target, sum , ans, i+1, temp);

    }
}