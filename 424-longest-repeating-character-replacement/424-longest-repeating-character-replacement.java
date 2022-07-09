class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] chars = new int[26];
        int left = 0;
        int right = 0;
        int mostFrequent = 0;
        while (right < s.length()) {
            int r = s.charAt(right)-'A';
            chars[r]++;
            mostFrequent = Math.max(mostFrequent, chars[r]);
            int len = right-left+1;
            if (len-mostFrequent <= k) {
                res = Math.max(res, len);
            } else {
                int l = s.charAt(left++)-'A';
                chars[l]--;
                mostFrequent = Math.max(mostFrequent, chars[l]);
            }
            right++;
        }
        
        return res;
    }
}