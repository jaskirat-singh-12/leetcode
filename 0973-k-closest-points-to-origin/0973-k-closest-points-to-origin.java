class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> Double.compare(
    Math.pow(a[0], 2) + Math.pow(a[1], 2), 
    Math.pow(b[0], 2) + Math.pow(b[1], 2)
));
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
}