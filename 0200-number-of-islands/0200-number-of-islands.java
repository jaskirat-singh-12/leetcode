
class Solution {
    public int numIslands(char[][] grid) {
        
        
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] graph, int i, int j, boolean[][] vis) {
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length) {
            return;
        }
        if(vis[i][j] || graph[i][j] == '0') {
            return;
        }

        vis[i][j] = true;

        dfs(graph, i-1, j, vis);
        dfs(graph, i, j-1, vis);
        dfs(graph, i, j+1, vis);
        dfs(graph, i+1, j, vis);
        
    }
}
