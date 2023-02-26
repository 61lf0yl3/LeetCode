class Solution {
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                int[] rc = q.poll();
                for (int i = 0; i < directions.length; i++) {
                    int newR = rc[0]+directions[i][0];
                    int newC = rc[1]+directions[i][1];
                    if (newR >= 0 && newC >= 0 && 
                        newR < n && newC < m && 
                        grid[newR][newC] == 1) {
                        
                        freshOranges--;
                        grid[newR][newC] = 2;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            if (!q.isEmpty()) {
                res++;
            }
        }
        
        return freshOranges == 0 ? res : -1;
    }
}