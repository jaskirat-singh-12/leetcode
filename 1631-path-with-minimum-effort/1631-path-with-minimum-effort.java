class Solution {
    class Pair{
        int i, j, effort;
        public Pair(int i, int j, int effort) {
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.effort, b.effort));
        pq.offer(new Pair(0,0,0));
        boolean[][] vis = new boolean[n][m];
        return minEffort(pq, heights, vis);
        
    }

    public int minEffort(PriorityQueue<Pair> pq, int[][] h, boolean[][] vis) {
        int[] row = {-1,0,1,0};
        int[] col = {0,-1,0,1};
        int n = h.length;
        int m = h[0].length;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if (vis[p.i][p.j])
                continue;

            vis[p.i][p.j] = true;

            if(p.i == n-1 && p.j == m-1) return p.effort;

            for(int i = 0; i < row.length; i++) {
                int idxI = p.i+row[i];
                int idxJ = p.j+col[i];
                if(idxI >= 0 && idxJ >=0 && 
                idxI < n && idxJ < m && 
                !vis[idxI][idxJ]) {

                    int edgeEffort = Math.abs(h[p.i][p.j] - h[idxI][idxJ]);

                    int newEffort = Math.max(p.effort, edgeEffort);
                    pq.offer(new Pair(idxI, idxJ, newEffort));
                }
            }

        }
        return -1;
    }
}