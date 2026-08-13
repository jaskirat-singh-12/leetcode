class Solution {
    class Pair{
        int i, j, cnt;
        public Pair(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid.length];
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;
        if(grid.length == 1 && grid[0][0] == 0) return 1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));
        vis[0][0] = true;

        return binaryMaze(grid, vis, q);
    }
    public int binaryMaze(int[][] grid, boolean[][] vis, Queue<Pair> q) {
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int i = q.peek().i;
            int j = q.peek().j;
            int cnt = q.peek().cnt;
            q.poll();
            // int[] dirI = {0, 1, 1, 1, 0};
            // int[] dirJ = {-1,-1, 0, 1,1};
            int[] dirI = {-1,-1,-1,0,0,1,1,1};
            int[] dirJ = {-1,0,1,-1,1,-1,0,1};
            for(int idx = 0; idx < dirI.length; idx++) {
                int newi = i + dirI[idx];
                int newj = j + dirJ[idx];
                if(newi >= 0 && newi < grid.length && newj >= 0 && newj < grid.length && !vis[newi][newj] && grid[newi][newj] == 0) {
                    vis[newi][newj] = true;
                    q.offer(new Pair(newi, newj, cnt+1));
                    if(newi == grid.length-1 && newj == grid.length-1) {
                        return cnt+1;
                    }
                }

            }
        }
        return -1;
    }
}