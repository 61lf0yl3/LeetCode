class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxes = new boolean[n][n];
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '1';
                
                if (rows[r][num]) {
                    return false;
                }
                rows[r][num] = true;
                
                if (cols[c][num]) {
                    return false;
                }
                cols[c][num] = true;
                
                int box = (r/3)*3 + c/3;
                if (boxes[box][num]) {
                    return false;
                }
                boxes[box][num] = true;
            }
        }
        return true;
    }
}