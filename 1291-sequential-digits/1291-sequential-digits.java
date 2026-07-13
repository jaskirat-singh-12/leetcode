class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < 9; i++) {
            q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int val = q.poll();

            if(val >= low && val <= high) {
                ans.add(val);
            }
            if(val > high) {
                continue;
            }
            else{
                int lastDigit = val % 10;
                if(lastDigit == 9){
                    continue;
                }
                val = (val * 10) + (lastDigit + 1);
                q.offer(val);
            }
        }
        return ans;
    }
}