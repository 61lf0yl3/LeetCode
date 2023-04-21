class Solution {
    public void rotate(int[][] matrix) {
        // transpose(matrix);
        // reverse(matrix);
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
    
//     private void rotate(int[][] matrix) {
        
//     }
    
//     private void reverse(int[][] matrix) {
        
//     }
    
}