class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for(int i =0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] f : flights) {
            int sr = f[0];
            int des = f[1];
            int wt = f[2];
            List<Integer> temp = new ArrayList<>();
            temp.add(sr);
            temp.add(des);
            temp.add(wt);
            graph.get(sr).add(temp);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
        q.offer(new Pair(src, 0, 0));

        int[][] dis = new int[n][k + 2];
        for(int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[src][0] = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int sr = p.node;
            int wt = p.wt;
            int pk = p.k;

            if (sr == dst ) {
                return wt;
            }

            if(pk > k) continue;

            for(List<Integer> neigh : graph.get(sr)) {
                int nt = neigh.get(1);
                int w = neigh.get(2);
                int newCost = wt + w;

                if (newCost < dis[nt][pk+1]) {
                    dis[nt][pk+1] = newCost;
                    q.offer(new Pair(nt,wt + w,pk+1));
                }
            }
        }
        return -1;

    }
    class Pair{
        int node, wt, k;
        public Pair(int node, int wt, int k) {
            this.node = node;
            this.wt = wt;
            this.k = k;
        }
    }
}