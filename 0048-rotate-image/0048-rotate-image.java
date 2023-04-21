class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
        //rotate2(matrix);
    }
    
    private void rotate2(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;
        
        while (left < right) {
            for (int i = 0; i < right-left; i++) {
                int top = left;
                int bottom = right;
                // safe the top left
                int topLeft = matrix[top][left+i];
                
                // overwrite top-left with bottom-left
                matrix[top][left+i] = matrix[bottom-i][left];
                
                // overwrite bottom-left with bottom-right
                matrix[bottom-i][left] = matrix[bottom][right-i];
                
                // overwrite bottom-right with top-right
                matrix[bottom][right-i] = matrix[top+i][right];
                
                // overwrite top-right with top-left;
                matrix[top+i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    
}