class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        vector<vector<int>> directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int n = rooms.size();
        int m = rooms[0].size();
        queue<vector<int>> gates;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rooms[r][c]==0) {
                    gates.push({r,c});
                }
            }
        }
        
        while (!gates.empty()) {
            vector<int> gate = gates.front();
            gates.pop();
            int r = gate[0];
            int c = gate[1];
            for (int i = 0; i < directions.size(); i++) {
                int newR = r+directions[i][0];
                int newC = c+directions[i][1];
                if (newR >= 0 && newC >= 0 && newR < n && newC < m && rooms[newR][newC] == INT_MAX) {
                    rooms[newR][newC] = rooms[r][c]+1;
                    gates.push({newR, newC});
                }
            }
        }
    }
};