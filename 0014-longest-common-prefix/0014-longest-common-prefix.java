class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(res.length(), strs[i].length()) && res.charAt(j)==strs[i].charAt(j)) {
                j++;
            }
            if (j < res.length()) {
                res = res.substring(0, j);
            }
        }
        return res;
    }
}