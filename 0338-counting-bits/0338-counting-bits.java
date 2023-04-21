class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int offset = 1;
        int i = 1;
        while (i <= n) {
            offset = offset*2 > i ? offset : offset*2;
            res[i] = 1+res[i-offset];
            i++;
        }
        return res;
    }
}