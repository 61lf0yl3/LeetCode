

class Solution {
    String s;
    public int countSubstrings(String s) {
        this.s = s;
        
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            res += expandPalindrome(i, i, 1);
            res += expandPalindrome(i, i+1, 2);
            
        }
        
        return res;
    }
    
    private int expandPalindrome(int start, int end, int size) {
        int L = start, R = end;
        int res = 0;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
            res++;
        }
        return res;
    }
    
}