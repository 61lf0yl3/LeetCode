class Solution {
    String s;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        this.s = s;
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int retSize = expandPalindrome(i, i, 1);
            retSize = Math.max(retSize, expandPalindrome(i, i+1, 2));
            
            if (retSize > end-start) {
                start = i - (retSize-1)/2;
                end = i + retSize/2;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    private int expandPalindrome(int start, int end, int size) {
        int L = start, R = end;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
}