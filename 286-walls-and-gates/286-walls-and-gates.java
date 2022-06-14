class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] sides = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> gates = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rooms[r][c]==0) {
                    gates.add(new int[]{r,c});
                }
            }
        }
        
        while (!gates.isEmpty()) {
            int[] gate = gates.poll();
            int r = gate[0];
            int c = gate[1];
            for (int[] side : sides) {
                int newR = r+side[0];
                int newC = c+side[1];
                if (newR >= 0 && newC >= 0 && newR < n && newC < m && rooms[newR][newC] == Integer.MAX_VALUE) {
                    rooms[newR][newC] = rooms[r][c]+1;
                    gates.add(new int[]{newR, newC});
                }
            }
        }
    }
}