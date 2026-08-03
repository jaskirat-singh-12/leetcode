class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add( new ArrayList<>());
        }

        for(int i = 0; i < pre.length; i++) {
            int u = pre[i][0];
            int v = pre[i][1];

            graph.get(v).add(u);
        }

        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            for(int neigh : graph.get(i)) inDegree[neigh]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }
        int num = 0;
        while(!q.isEmpty()) {
            int p = q.poll();
            
            num++;

            for(int neigh : graph.get(p)) {
                inDegree[neigh]--;

                if(inDegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        return (numCourses == num);

    }
}