class Solution {

private:
    int n;
    int m;
    vector<vector<int>> grid;
    int dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(r+1, c) + dfs(r-1, c) + dfs(r, c+1) + dfs(r, c-1);
}
    
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        this->grid = grid;
        this->n = grid.size();
        this->m = grid[0].size();
        
        int res = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    res = max(res, dfs(r, c));
                }
            }
        }
        
        return res;
    }
    
};