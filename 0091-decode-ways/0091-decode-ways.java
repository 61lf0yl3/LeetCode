class Solution {
    String s;
    Map<Integer, Integer> memo;
    public int numDecodings(String s) {
        this.s = s;
        this.memo = new HashMap<>();
        return dfs(0);
    }
    
    private int dfs(int i) {
        if (i >= s.length()) {
            return 1;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (i == s.length()-1) {
            return 1;
        }
        int res = dfs(i+1);
        if (Integer.parseInt(s.substring(i, i+2)) <= 26) {
            res += dfs(i+2);
        }
        memo.put(i, res);
        return res;
    }
}