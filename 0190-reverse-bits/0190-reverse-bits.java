public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 31; i++) {
            //get last bit from;
            int bit = n & 1;
            
            // update the last bit
            res = res | bit;
            
            // shift to left by 1
            res = res << 1;
            
            // update the n;
            n = n >> 1;
        }
        
        int bit = n & 1;
        res = res | bit;
        
        return res;
    }
}