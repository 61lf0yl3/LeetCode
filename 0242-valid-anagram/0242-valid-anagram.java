class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (chars[c-'a'] == 0) {
                return false;
            }
            chars[c-'a']--;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}