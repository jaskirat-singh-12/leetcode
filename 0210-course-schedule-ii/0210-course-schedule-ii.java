class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            graph[v].add(u);
        }

        for(int i = 0; i < numCourses; i++) {
            for(int neigh : graph[i]) {
                indegree[neigh]++;
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int idx = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            ans[idx] = node;
            idx++;
            for(int neigh = 0; neigh < graph[node].size(); neigh++) {
                indegree[graph[node].get(neigh)]--;
                if(indegree[graph[node].get(neigh)] == 0) {
                    q.offer(graph[node].get(neigh));
                }
            }
        }
        if (idx != numCourses) {
            return new int[0];
        }
        return ans;
    }
}