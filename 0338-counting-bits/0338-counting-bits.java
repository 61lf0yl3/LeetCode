class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int bits = 0;
            int m = i;
            while (m != 0) {
                bits++;
                m &= m-1;
            }
            res[i] = bits;
        }
        return res;
    }
}