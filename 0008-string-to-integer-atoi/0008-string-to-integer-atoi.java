class Solution {
    public int myAtoi(String s) {
        int SIGN = 1;
        int res = 0;
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i)==' ') {
            i++;
        }
        
        if (i < n && s.charAt(i) == '+') {
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            SIGN = -1;
            i++;
        }
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i)-'0';
            if ((res > Integer.MAX_VALUE/10) || 
                (res == Integer.MAX_VALUE/10 && d > Integer.MAX_VALUE % 10)) {
                return SIGN == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res*10 + d;
            i++;
        }
        return res*SIGN;
    }
}