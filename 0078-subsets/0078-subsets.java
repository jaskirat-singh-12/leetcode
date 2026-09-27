class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void subset(int[] nums, List<Integer> temp, int i) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subset(nums, temp, i+1);
        temp.remove(temp.size()-1);
        subset(nums, temp, i+1);

        return;
    }
}