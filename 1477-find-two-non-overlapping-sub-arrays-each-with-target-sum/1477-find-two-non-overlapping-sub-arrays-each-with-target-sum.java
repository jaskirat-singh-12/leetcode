class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] prev = new int[n];

        int i = 0, j = 0;
       
        int ans = Integer.MAX_VALUE;
        int curr = 0;
        int bestMin = Integer.MAX_VALUE;

        while(j < n) {
            curr += arr[j];
            while(curr > target) {
                curr -= arr[i];
                i++;
            }
            int len = j-i+1;
            if(curr == target) {
                if(i > 0 && prev[i-1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + prev[i-1]);
                }
                bestMin = Math.min(bestMin, len);
            }
            prev[j] = bestMin;
            j++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
