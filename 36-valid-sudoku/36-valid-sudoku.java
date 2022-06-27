class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[][] boxes = new int[n][n];
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '1';
                
                if (rows[r][num]==1) {
                    return false;
                }
                rows[r][num]++;
                
                if (cols[c][num]==1) {
                    return false;
                }
                cols[c][num]++;
                
                int box = (r/3)*3 + c/3;
                if (boxes[box][num]==1) {
                    return false;
                }
                boxes[box][num]++;
            }
        }
        return true;
    }
}