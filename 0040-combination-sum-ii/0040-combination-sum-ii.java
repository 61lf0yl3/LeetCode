class Solution {
    List<List<Integer>> res;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        res = new ArrayList<List<Integer>>();
        backtrack(new LinkedList<>(), target, 0);
        return res;
    }
    
    private void backtrack(LinkedList<Integer> comb, int target, int start) {
        if (target == 0) {
            res.add(new LinkedList<>(comb));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i != start && candidates[i-1] == candidates[i]) {
                    continue;
                }
                comb.add(candidates[i]);
                backtrack(comb, target-candidates[i], i+1);
                comb.removeLast();
            }
        }
    }
}