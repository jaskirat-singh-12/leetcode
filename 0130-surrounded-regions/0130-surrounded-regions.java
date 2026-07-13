class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];


        for(int i = 0; i < n; i++) {
                if(!vis[i][0] && board[i][0] == 'O') {
                    dfs(board, vis, i, 0);
                }
        }

        for(int i = 0; i < m; i++) {
                if(!vis[0][i] && board[0][i] == 'O') {
                    dfs(board, vis, 0, i);
                }
        }
        
        for(int i = 0; i < n; i++) {
                if(!vis[i][m-1] && board[i][m-1] == 'O') {
                    dfs(board, vis, i, m-1);
                }
        }

        for(int i = 0; i < m; i++) {
                if(!vis[n-1][i] && board[n-1][i] == 'O') {
                    dfs(board, vis, n-1, i);
                }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][] vis, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if(i >= n || j >= m || i < 0 || j < 0 || vis[i][j]) {
            return;
        }

        if(board[i][j] == 'X') {
            return;
        }

        vis[i][j] = true;
            dfs(board, vis, i+1, j);
            dfs(board, vis, i-1, j);
            dfs(board, vis, i, j+1);
            dfs(board, vis, i, j-1);
        
        
    }

}