class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            for(int j = 0; j < n; j++) {    
                if(isConnected[i][j] == 1) {
                    int u = i;
                    int v = j;

                    graph[i].add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ans++;
                dfs(graph, vis, i);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<Integer>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        for(int neigh : graph[curr]) {
            if(!vis[neigh]) {

                dfs(graph, vis, neigh);
            }
        }
    }
}