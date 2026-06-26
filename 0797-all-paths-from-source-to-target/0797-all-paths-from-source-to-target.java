class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        temp.add(0);
        
        checkPaths(graph, 0, graph.length - 1, ans, temp);

        return ans;
    }
    public void checkPaths(int[][] graph, int src, int dest, List<List<Integer>> ans, List<Integer> temp) {
        if(src == dest) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int neigh = 0; neigh < graph[src].length; neigh++) {
            int curr = graph[src][neigh];
            temp.add(curr);
            checkPaths(graph, curr, dest, ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}