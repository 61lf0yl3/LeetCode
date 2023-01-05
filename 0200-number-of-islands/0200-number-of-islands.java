class Solution {
    char[][] grid;
    int n;
    int m;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int res = 0;
        n = grid.length;
        m = grid[0].length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(r, c);
                }
            }
        }
        return res;
    }
    
    private void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r+1, c);
        dfs(r, c-1);
    }
}