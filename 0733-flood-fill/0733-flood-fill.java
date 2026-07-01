class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];

        dfs(image, image[sr][sc], sr, sc, color, vis);
        return image;
    }

    public void dfs(int[][] image, int idealColor, int i, int j, int color, boolean[][] vis) {
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || vis[i][j] || image[i][j] != idealColor) {
            return;
        }
        vis[i][j] = true;
        image[i][j] = color;

        dfs(image, idealColor, i-1, j, color, vis);
        dfs(image, idealColor, i+1, j, color, vis);
        dfs(image, idealColor, i, j-1, color, vis);
        dfs(image, idealColor, i, j+1, color, vis);
    }
}