class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        n = grid.size();
        m = grid[0].size();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }
    
private:
    int n;
    int m;
    void dfs(vector<vector<char>>& grid, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
    }
};

