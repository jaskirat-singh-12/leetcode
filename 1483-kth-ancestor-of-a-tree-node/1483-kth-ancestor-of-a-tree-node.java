class TreeAncestor {
    int[][] ans;
    int row;
    int col;
    public TreeAncestor(int n, int[] parent) {
        row = n;
        col = logBaseTwo(n) + 1;
        ans = new int[row][col];

        for(int[] r : ans) {
            Arrays.fill(r, -1);
        }

        for(int i = 0; i < n; i++) {
            ans[i][0] = parent[i];
        }

        for(int i = 1; i < col; i++) {
            for(int j = 0; j < n; j++) {
                if(ans[j][i-1] >= 0) {
                    ans[j][i] = ans[ans[j][i-1]][i-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        for(int i = 0; i < col; i++) {
            if((k & (1 << i)) != 0) {
                node = ans[node][i];
            }

            if(node <= -1) return -1;
        }
        return node;
    }

    private int logBaseTwo(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */