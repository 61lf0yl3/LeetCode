class Solution {
    List<List<Integer>> res = new LinkedList();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return res;
    }
    
    public void backtrack(int nb, LinkedList<Integer> solution) {
        if (solution.size() == k) {
            res.add(new LinkedList(solution));
            return;
        } else {
        
        for (int i = nb; i<=n; i++) {
            solution.add(i);
            backtrack(i+1, solution);
            solution.removeLast();
        }
        }
    }
}