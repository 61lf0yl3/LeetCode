class Solution {

private:
    int n;
    int m;
    vector<vector<int>> heights; 
    vector<vector<int>> directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    void dfs(int r, int c, vector<vector<bool>>& reachable) {
        reachable[r][c] = true;
        for (int i = 0; i < directions.size(); i++) {
            int newR = r+directions[i][0];
            int newC = c+directions[i][1];
            if (newR < 0 || newC < 0 || newR >= n || newC >= m || reachable[newR][newC] || heights[r][c] > heights[newR][newC]) {
                continue;
            }
            dfs(newR, newC, reachable);
        }
    }

public:
    
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        this->n = heights.size();
        this->m = heights[0].size();
        this->heights = heights;
        
        vector<vector<int>> res;
        
        vector<vector<bool>> pacific(n, vector<bool>(m));
        vector<vector<bool>> atlantic(n, vector<bool>(m));
        
        for (int r = 0; r < n; r++) {
            dfs(r, 0, pacific);
            dfs(r, m-1, atlantic);
        }
        
        for (int c = 0; c < m; c++) {
            dfs(0, c, pacific);
            dfs(n-1, c, atlantic);
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.push_back({r, c});
                }
            }
        }
        
        return res;
    }
};