class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxAns = 0;
        int n = img1.length;
        for(int i = -n+1; i < n; i++) {
            for(int j = -n+1; j < n; j++) {
                maxAns = Math.max(maxAns, find(img1, img2, i, j));
            }
        }

        return maxAns;
    }

    public int find(int[][] A, int[][] B, int row, int col) {
        int n = A.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i + row >= n || j + col >= n || i + row < 0 || j + col < 0) {
                    continue;
                }
                if(A[i][j] == B[i + row][j+col] && A[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}