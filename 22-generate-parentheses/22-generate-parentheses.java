class Solution {
    private List<String> res;
    private int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;
        backtrack(new StringBuilder(), 0, 0);
        return res;
    }
    
    private void backtrack(StringBuilder comb, int open, int close) {
       if (open == n && close == n) {
            res.add(comb.toString());
       }
       if (open < n) {
           comb.append('(');
           backtrack(comb, open+1, close);
           comb.deleteCharAt(comb.length()-1);
       }
       if (close < open) {
           comb.append(')');
           backtrack(comb, open, close+1);
           comb.deleteCharAt(comb.length()-1);
       }
    }
}