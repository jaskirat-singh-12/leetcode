class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int time = r[2];

            graph.get(u).add(new int[] {v,time});
            graph.get(v).add(new int[] {u,time});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));

        long[] dis = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dis, Long.MAX_VALUE);
        
        dis[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            long wt = p.time;
            int u = p.u;

            if(wt > dis[u]) continue;
            for(int[] neigh : graph.get(u)) {
                int time = neigh[1];
                int v = neigh[0];
                if(time + wt < dis[v]) {
                    dis[v] = (time + wt);
                    ways[v] = ways[u];
                    pq.offer(new Pair(neigh[0], dis[v]));
                }
                else if(time + wt == dis[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
                
            }
        }
        return ways[n-1];
    
    }
    class Pair{
        int u;
        long time;

        public Pair(int u, long time) {
            this.u = u;
            this.time = time;
        }
    }
}