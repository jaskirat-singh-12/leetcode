class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2 ) {
                    q.offer(new Pair(i,j));
                    vis[i][j] = true;
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        ans = bfs(grid, vis, q, fresh);
        return ans;
    }

    public int bfs(int[][] grid, boolean[][] vis, Queue<Pair> q, int fresh) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int ans = 0;

        while(!q.isEmpty()) {
            boolean rottoned = false;
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Pair p = q.poll();
                
                for(int k = 0; k < 4; k++) {
                    int ndr = dr[k] + p.i;
                    int ndc = dc[k] + p.j;

                    if(ndr >= 0 && ndc >= 0 && ndr < grid.length && ndc < grid[0].length && grid[ndr][ndc] == 1 && !vis[ndr][ndc]) {
                        q.offer(new Pair(ndr, ndc));
                        vis[ndr][ndc] = true;
                        rottoned = true;
                        fresh--;
                    }
                }
            }
            if(rottoned) ans++;
        }
        return fresh == 0 ? ans : -1;
    }
}
class Pair{
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}