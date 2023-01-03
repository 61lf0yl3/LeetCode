class Solution {
    char[][] board;
    boolean[][] memo;
    int n;
    int m;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        this.memo = new boolean[n][m];
        this.word = word;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (backtrack(r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(int r, int c, int i) {
        if (i >= word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= n || c >= m || memo[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        memo[r][c] = true;
        boolean res = backtrack(r-1, c, i+1) || 
                backtrack(r, c+1, i+1) || 
                backtrack(r+1, c, i+1) || 
                backtrack(r, c-1, i+1);
        memo[r][c] = false;
        return res;
    }
}