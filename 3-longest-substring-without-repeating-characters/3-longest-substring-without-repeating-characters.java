class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (m.containsKey(c)) {
                left = Math.max(left, m.get(c)+1);
            }
            res = Math.max(res, right-left+1);
            m.put(c, right);
        }
        return res;
    }
}