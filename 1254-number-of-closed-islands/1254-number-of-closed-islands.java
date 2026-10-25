class Solution {
    public int closedIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for(int i = 1; i < grid.length-1; i++) {
            for(int j = 1; j < grid[0].length-1; j++) {
                if(!vis[i][j] && grid[i][j] == 0) {
                    if(isIsland(grid, i, j, vis)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean isIsland(int[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;
        vis[i][j] = true;

        boolean left = isIsland(grid, i,j-1, vis);
        boolean down = isIsland(grid, i-1,j, vis);
        boolean up = isIsland(grid, i+1,j, vis);
        boolean right = isIsland(grid, i,j+1, vis);
        return left && right && up && down;
    }
}