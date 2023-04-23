class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int resLeft = 0;
        int res = s.length()+1; 
        int left = 0;
        int have = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currR = s.charAt(right);
            
            // if char from t them decrement it
            if (map.containsKey(currR)) {
                // if char from t them decrement it
                map.put(currR, map.get(currR)-1);
                // if value is zero which means we satifsied frequency for this letter
                if (map.get(currR) == 0) {
                    have++;
                }
            }
            
            // check if substring satisfies
            // if substring satisfies move left pointer
            while (have == map.size()) {
                if (res > right-left+1) {
                    resLeft = left;
                    res = right-left+1;
                }
                char currL = s.charAt(left);
                if (map.containsKey(currL)) {
                    if (map.get(currL) == 0) {
                        have--;
                    }
                    map.put(currL, map.get(currL)+1);
                }
                left++;
            }
        }
                
        return res == s.length()+1 ? "" : s.substring(resLeft, resLeft+res);
    }
}