class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        for (int center = 0; center < s.length(); center++) {
            int len1 = expandAroundCenter(s, center, center);
            int len2 = expandAroundCenter(s, center, center+1);
            int len = Math.max(len1, len2);
            if (max < len) {
                max = len;
                start = center - (len-1)/2;
                end = center + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
        }
        return right-left-1;
    }
}