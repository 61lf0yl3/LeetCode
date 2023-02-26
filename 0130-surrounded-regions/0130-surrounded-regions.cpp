class Solution {
private:
    int n;
    int m;
    
    void dfs(int r, int c, vector<vector<char>>& board) {
        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'o';
        dfs(r, c-1, board);
        dfs(r-1, c, board);
        dfs(r, c+1, board);
        dfs(r+1, c, board);
    }
    
public:
    void solve(vector<vector<char>>& board) {
        this->n = board.size();
        this->m = board[0].size();
        
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') dfs(r, 0, board);
            if (board[r][m-1] == 'O') dfs(r, m-1, board);
        }
        
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') dfs(0, c, board);
            if (board[n-1][c] == 'O') dfs(n-1, c, board);
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'o') board[r][c] = 'O';
            }
        }
    }
};