class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int temp = matrix[mid/m][mid%m];
            if (temp==target) {
                return true;
            } else if (temp>target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}