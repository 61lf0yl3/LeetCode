class Solution {
    List<List<String>> res;
    String s;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.s = s;
        backtrack(new LinkedList<>(), 0);
        return res;
    }
    
    private void backtrack(LinkedList<String> comb, int start) {
        if (start >= s.length()) {
            res.add(new LinkedList<>(comb));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i)) {
                comb.add(s.substring(start, i+1));
                backtrack(comb, i+1);
                comb.removeLast();
            }
        }
    }
    
    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}