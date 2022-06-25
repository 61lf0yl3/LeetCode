class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList> m = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('.');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(str);
        }
        
        return new ArrayList(m.values());
    }
}