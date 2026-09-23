class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            graph.get(u).add( new ArrayList<>(Arrays.asList(v, t)));

        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);

        pq.offer(new Pair(k, 0, 0));

        return findTime(graph, pq, n, k);
    }

    public int findTime(ArrayList<ArrayList<ArrayList<Integer>>> graph, PriorityQueue<Pair> pq, int n, int k) {
        int ans = 0;
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[k] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int nn = p.node;
            int time = p.time;
            int l = p.lvl;

            if(time > dis[nn]) {
                continue;
            }

            for(ArrayList<Integer> neigh : graph.get(nn)) {
                int node = neigh.get(0);
                int t = neigh.get(1) + time;
                int lvl = l+1;
                if(t < dis[node]) {
                    dis[node] = t;
                    pq.offer(new Pair(node,t,lvl));
                }
            }

        }
        for(int i = 1; i <= n; i++) {

        if(dis[i] == Integer.MAX_VALUE) {
            return -1;
        }

        ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}

class Pair{
    int node;
    int time;
    int lvl;

    public Pair(int node, int time, int lvl) {
        this.node = node;
        this.time = time;
        this.lvl = lvl;
    }
}
