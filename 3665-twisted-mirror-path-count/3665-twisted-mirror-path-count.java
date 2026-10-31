class Solution {
    public int uniquePaths(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][2];

        for(int[][] rows : dp) {
            for(int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }

        return findPath(grid, 0, 0, 0, dp);
    }
    private int findPath(int[][] grid, int i, int j, int dir, int[][][] dp) {
        int MOD = 1000000007;
        int n = grid[0].length;
        int m = grid.length;

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j][dir] != -1) return dp[i][j][dir];


        int ans = 0;

        if(grid[i][j] == 1) {
            if(dir == 0) 
                ans = findPath(grid, i+1,j, 1, dp);
            else{
                ans = findPath(grid, i,j+1, 0, dp);
            }
        }
        else {
            ans = (findPath(grid, i, j+1, 0, dp) + findPath(grid, i+1,j, 1, dp) % MOD);
        }
        return dp[i][j][dir] = ans % MOD;
    }
}