class Solution {
    public int minDifficulty(int[] job, int d) {
        if(d > job.length) return -1;
        
        int[][] dp = new int[d+1][job.length+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return diff(job, d, 0, dp);
    }

    public int diff(int[] job, int d, int i, int[][] dp) {
        if(i > job.length) return 0;

        if(d == 1) {
            int max = job[i];

            for(int idx = i; idx < job.length; idx++) {
                max = Math.max(max, job[idx]);
            }
            return max;
        }

        if(dp[d][i] != -1) return dp[d][i];


        int max = job[i];
        int ans = Integer.MAX_VALUE;

        for(int idx = i; idx <= job.length-d; idx++) {
            max = Math.max(max, job[idx]);

            int curr = max + diff(job, d-1, idx+1, dp);

            ans = Math.min(curr, ans);
        }
        return dp[d][i] = ans;
    }
}