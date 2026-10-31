class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

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

        int com = n;

        for(int i = 0; i < connections.length; i++) {
            int x = find(connections[i][0]);
            int y = find(connections[i][1]);

            if(x != y) {
                union(x,y);
                com--;
            }
        }
        return com-1;


    }

    public int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int par_x = find(x);
        int par_y = find(y);

        // if(par_x == par_y) return;

        if(rank[par_x] < rank[par_y]) {
            parent[par_x] = par_y;
        }
        else if(rank[par_x] > rank[par_y]) {
            parent[par_y] = par_x;
        }
        else{
            parent[par_x] = par_y;
            rank[par_y]++;
        }
    }
}