class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += expandAroundCenter(s, i, i);
            res += expandAroundCenter(s, i, i+1);
        }
        return res;
    }
    
    private int expandAroundCenter(String s, int i, int j) {
        int res = 0;
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }
    
    
}