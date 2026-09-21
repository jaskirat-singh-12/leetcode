class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                   res = Math.max(res, findArea(grid, i, j, vis));
                }
            }
        }
        return res;
    }
    public int findArea(int[][] grid,int i,int j,boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if(i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        if(vis[i][j]) return 0;
        vis[i][j] = true;

        return 1 + findArea(grid, i+1,j,vis) + findArea(grid, i-1,j,vis) + findArea(grid, i,j-1,vis) + findArea(grid, i,j+1,vis);

    }
}