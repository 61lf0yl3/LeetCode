class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(0, s, new HashSet<>(wordDict), new Boolean[s.length()]);
    }
    
    public boolean dfs(int start, String s, HashSet<String> set, Boolean[] memo) {
        if (start >= s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start; end < s.length(); end++) {
            if (set.contains(s.substring(start, end+1)) && dfs(end+1, s, set, memo)) {
                return memo[start]=true;
            }
        }
        return memo[start]=false;
    }
}