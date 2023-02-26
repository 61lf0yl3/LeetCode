class Solution {
    private int n;
    private int m;
    private int[][] heights; 
    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        this.heights = heights;
        
        List<List<Integer>> res = new ArrayList<>();
        
        boolean[][] pacificReachable = new boolean[n][m];
        boolean[][] atlanticReachable = new boolean[n][m];
        
        for (int r = 0; r < n; r++) {
            dfs(r, 0, pacificReachable);
            dfs(r, m-1, atlanticReachable);
        }
        
        for (int c = 0; c < m; c++) {
            dfs(0, c, pacificReachable);
            dfs(n-1, c, atlanticReachable);
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int r, int c, boolean[][] reachable) {
        reachable[r][c] = true;
        for (int i = 0; i < directions.length; i++) {
            int newR = r+directions[i][0];
            int newC = c+directions[i][1];
            if (newR < 0 || newC < 0 || newR >= n || newC >= m || reachable[newR][newC] || heights[r][c] > heights[newR][newC]) {
                continue;
            }
            dfs(newR, newC, reachable);
        }
    }
}