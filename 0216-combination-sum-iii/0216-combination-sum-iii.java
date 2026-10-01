class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum3(k, n, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void combinationSum3(int k, int n, List<List<Integer>> ans, List<Integer> temp, int val) {
        if(val > 9) {
            if(k == temp.size() && n == 0) {
                ans.add(new ArrayList<>(temp));

            }
            return;
        }
        if(n < 0 || temp.size() > k) {
            return;
        }
        temp.add(val);
        combinationSum3(k, n-val, ans, temp, val+1);
        temp.remove(temp.size()-1);

        combinationSum3(k, n, ans, temp, val+1);
    }
}