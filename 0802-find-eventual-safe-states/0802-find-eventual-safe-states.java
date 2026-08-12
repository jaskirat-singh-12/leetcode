class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            for(int graphs : graph[i]) {
                adj.get(graphs).add(i);
            }
            indegree[i] = graph[i].length;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] isSafe = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int i = q.poll();
            isSafe[i] = true;

            for(int neig : adj.get(i)) {
                indegree[neig]--;
                if(indegree[neig] == 0) {
                    q.offer(neig);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(isSafe[i]) ans.add(i);
        }
        return ans;
    }
}