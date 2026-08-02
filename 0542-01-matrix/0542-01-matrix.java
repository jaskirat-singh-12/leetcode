class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        bfs(mat, ans, vis, q);
        return ans;
    }
    public void bfs(int[][] mat, int[][] ans, boolean[][] vis, Queue<Pair> q) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        

        while(!q.isEmpty()) {
            // int size = q.size();

            // for(int n = 0; n < size; n++) {
                Pair p = q.poll();
                ans[p.i][p.j] = p.dis;

                for(int k = 0; k < 4; k++) {
                    int ndr = dr[k] + p.i;
                    int ndc = dc[k] + p.j;

                    
                    if(ndr >= 0 && ndc >= 0 && ndr < mat.length && ndc < mat[0].length && !vis[ndr][ndc]){
                        vis[ndr][ndc] = true;
                        q.offer(new Pair(ndr, ndc, p.dis+1));
                    }
                }
            // }
        }
        return;
    }

    class Pair {
        int i, j, dis;

        public Pair(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }
}