class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        int freshOranges = 0;
        queue<vector<int>> q;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    q.push({r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        int res = 0;
        while (!q.empty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                vector<int> rc = q.front();
                q.pop();
                for (int i = 0; i < directions.size(); i++) {
                    int newR = rc[0]+directions[i][0];
                    int newC = rc[1]+directions[i][1];
                    if (newR >= 0 && newC >= 0 && 
                        newR < n && newC < m && 
                        grid[newR][newC] == 1) {
                        
                        freshOranges--;
                        grid[newR][newC] = 2;
                        q.push({newR, newC});
                    }
                }
            }
            if (!q.empty()) {
                res++;
            }
        }
        
        return freshOranges == 0 ? res : -1;
    }
};