class Solution {
    int n;
    int m;
    char[][] board;
    
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') dfs(r, 0);
            if (board[r][m-1] == 'O') dfs(r, m-1);
        }
        
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') dfs(0, c);
            if (board[n-1][c] == 'O') dfs(n-1, c);
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'o') board[r][c] = 'O';
            }
        }
    }
    
    private void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'o';
        dfs(r, c-1);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r+1, c);
    }
}