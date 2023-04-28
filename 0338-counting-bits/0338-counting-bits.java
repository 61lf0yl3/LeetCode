class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int back = 1;
        for (int i = 1; i <= n; i++) {
            // most signofcant bit
            back = back*2 > i ? back : back*2;
            res[i] = 1 + res[i-back];
        }
        return res;
    }
}