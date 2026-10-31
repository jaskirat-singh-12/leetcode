class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

        boolean[] vis = new boolean[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                bfs(graph, vis, i);
                count++;
            }
        }
        return count-1;
    }

    public void bfs(Map<Integer, List<Integer>> graph, boolean[] vis, int start) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        vis[start] = true;

        while(!q.isEmpty()) {
            int main = q.poll();

            for(int nei : graph.get(main)){
                if(!vis[nei]) {
                    q.offer(nei);
                    vis[nei] = true;
                }
            }
        }
        
    }
}