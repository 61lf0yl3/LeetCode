class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int res = 0;
        int[] chars = new int[26];
        while (r < s.length()) {
            chars[s.charAt(r)-'A']++;
            int frequentChar = 0;
            for (int frequency : chars) {
                frequentChar = Math.max(frequentChar, frequency);
            }
            int lenthSubstring = r-l+1;
            // invalid substring
            if (lenthSubstring - frequentChar > k) {
                // move left
                chars[s.charAt(l++)-'A']--;
                chars[s.charAt(r)-'A']--;
            } else {
                // valid
                res = Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }
}