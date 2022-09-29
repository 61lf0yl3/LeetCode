class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = 0;
        int right = matrix[0].length-1;
        
        int up = 0;
        int down = matrix.length-1;
        
        while (res.size() < n*m) {
            // Traverse from left to right.
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            
            // Traverse downwards.
            for (int i = up+1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            
             // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int i = right-1; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int i = down-1; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}