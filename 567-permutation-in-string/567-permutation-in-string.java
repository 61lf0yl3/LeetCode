class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        for (char c : s1.toCharArray()) {
            chars[c-'a']++;
        }
        int left = 0;
        //int right = 0;
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            if (chars[c-'a']==0) {
                chars[s2.charAt(left)-'a']++;
                left++;
                right--;
                continue;
            } else {
                chars[c-'a']--;
                if (right-left+1==s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}