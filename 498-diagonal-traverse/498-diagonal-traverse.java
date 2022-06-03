class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n*m];
        int i = 0;
        for (int d = 0; d < n+m-1; d++) {
            int r = d < m ? 0 : d-m+1;
            int c = d < m ? d : m-1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (r < n && c >= 0) {
                temp.add(mat[r++][c--]);
            }
            if (d%2==0) {
                Collections.reverse(temp);
            } 
                for (int num : temp) {
                    res[i++] = num;
                }
            
        }
        return res;
    }
}