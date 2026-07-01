class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        boolean vis[][] = new boolean[image.length][image[0].length];

        bfs(image, image[sr][sc], sr, sc, color, vis);
        return image;
    }
    public void bfs(int[][] image, int idealColor, int i, int j, int color, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();

        vis[i][j] = true;
        q.offer(new Pair(i, j));
        image[i][j] = color;

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int row = p.i;
            int col = p.j;

            for(int k = 0; k < 4; k++) {
                int nr = row+ dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == idealColor && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    image[nr][nc] = color;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }
}

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}