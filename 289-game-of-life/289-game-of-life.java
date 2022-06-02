class Solution {
    int[][] neighbors = new int[][]{{-1,-1}, {0,-1}, {1,-1}, {-1,0}, {1,0}, {-1,1}, {0,1}, {1,1}};
    public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                bfs(board, r, c);
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c]==2) {
                    board[r][c] = 1;
                } else if (board[r][c]==-1){
                    board[r][c] = 0;
                }    
            }
        }
    }
    
    public void bfs(int[][] board, int r, int c) {
        int livecell = 0;
        for (int[] neighbor : neighbors) {
            int newR = r+neighbor[0];
            int newC = c+neighbor[1];
            if (newR >= 0 && newC >= 0 && newR < board.length && newC < board[0].length && Math.abs(board[newR][newC])%2 == 1) {
                    livecell++;
            }
        }
        if (Math.abs(board[r][c])%2 == 1) {
            if (livecell < 2) {
                board[r][c] = -1;
            } else if (livecell == 2 || livecell == 3) {
                board[r][c] = 1;
            } else {
                board[r][c] = -1;
            }
        } else {
            if (livecell == 3) {
                board[r][c] = 2;
            }
        }
    }
}