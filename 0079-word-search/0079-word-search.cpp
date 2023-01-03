class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        this->board = board;
        this->n = board.size();
        this->m = board[0].size();
        this->word = word;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == word[0]) {
                    if (backtrack(r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
private:
    vector<vector<char>> board;
    int n;
    int m;
    string word;
    bool backtrack(int r, int c, int i) {
        if (i >= word.size()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != word[i]) {
            return false;
        }
        board[r][c] = '#';
        bool res = backtrack(r-1, c, i+1) || 
                backtrack(r, c+1, i+1) || 
                backtrack(r+1, c, i+1) || 
                backtrack(r, c-1, i+1);
        board[r][c] = word[i];
        return res;
    }
};
