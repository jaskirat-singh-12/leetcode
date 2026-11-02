class Solution {
    public long countPairs(int n, int[][] edges) {
        // if(edges.length == 0) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] nonConnected = new int[n];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int idx = 0;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                nonConnected[idx++] = bfs(graph, vis, i);
            }
        }

        long ans = 0;
        int remaining = n;
        for(int i = 0; i < idx; i++) {
            remaining -= nonConnected[i];
            ans += (long) nonConnected[i] * remaining;
        }

        return ans;

    }

    public int bfs(Map<Integer, List<Integer>> graph, boolean[] vis, int start) {
        // if(graph.get(start).size() == 0) return 1;

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        vis[start] = true;
        int ans = 0;

        while(!q.isEmpty()) {
            int val = q.poll();
            ans++;

            for(int nei : graph.get(val)) {
                if(!vis[nei]) {
                    q.offer(nei);
                    vis[nei] = true;
                }
            }
        }
        return ans;
    }
}