class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0)+1);
        }
        
        int resLen = s.length()+1;
        int leftRes = 0;
        int left = 0;
        int have = 0; 
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (needMap.containsKey(c)) {
                needMap.put(c, needMap.get(c)-1);
                if (needMap.get(c) == 0) {
                    have++;
                }
            }
            
            while (have == needMap.size()) {
                if (resLen > right-left+1) {
                    resLen = right-left+1;
                    leftRes = left;
                }
                char temp = s.charAt(left);
                if (needMap.containsKey(temp)) {
                    if (needMap.get(temp) == 0) {
                        have--;
                    }
                    needMap.put(temp, needMap.get(temp)+1);
                }
                left++;
            }
        }
        
        return resLen == s.length()+1 ? "" : s.substring(leftRes, leftRes+resLen);
    }
}