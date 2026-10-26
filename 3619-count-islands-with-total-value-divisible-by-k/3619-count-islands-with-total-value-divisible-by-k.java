class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    if(dfs(grid, i, j) % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private long dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if(grid[i][j] == 0) {
            return 0;
        }
        long ans = grid[i][j];
        long up = 0, down = 0, right = 0, left = 0;
        grid[i][j] = 0;

        up = dfs(grid,  i-1, j);
        down = dfs(grid, i+1, j);
        left = dfs(grid, i, j-1);
        right = dfs(grid, i, j+1);
        
        
        return ans + up + down + right + left;
    }
}