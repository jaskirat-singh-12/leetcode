class Pair{
    int first;
    int sec;

    public Pair(int first, int sec) {
        this.first = first;
        this.sec = sec;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        
        
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] graph, int i, int j, boolean[][] vis) {
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        vis[i][j] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().sec;

            q.remove();

            for(int k = 0 ; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 &&
                   nr < graph.length && nc < graph[0].length &&
                   graph[nr][nc] == '1' && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }
}
