class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            if(!vis[i][0] && grid[i][0] == 1) {
                dfs(vis, grid, i, 0);
            }
        }
        for(int i = 0; i < grid[0].length; i++) {
            if(!vis[0][i] && grid[0][i] == 1) {
                dfs(vis, grid, 0, i);
            }
        }
        for(int i = 0; i < grid.length; i++) {
            if(!vis[i][grid[0].length-1] && grid[i][grid[0].length-1] == 1) {
                dfs(vis, grid, i, grid[0].length-1);
            }
        }
        for(int i = 0; i < grid[0].length; i++) {
            if(!vis[grid.length - 1][i] && grid[grid.length-1][i] == 1) {
                dfs(vis, grid, grid.length-1, i);
            }
        }
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(boolean[][] vis, int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;

        vis[i][j] = true;

        grid[i][j] = 0;
        dfs(vis, grid, i+1,j);
        dfs(vis, grid, i-1,j);
        dfs(vis, grid, i,j+1);
        dfs(vis, grid, i,j-1);
    }
}