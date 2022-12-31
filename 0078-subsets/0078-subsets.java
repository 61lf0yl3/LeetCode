class Solution {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        
        for (int i = 0; i <= nums.length; i++) {
            backtrack(i, 0, new LinkedList<>());
        }
        
        return res;
        
    }
    
    private void backtrack(int size, int start, LinkedList<Integer> comb) {
        if (comb.size() == size) {
            res.add(new LinkedList<>(comb));
        } else {
            for (int i = start; i < nums.length; i++) {
                comb.add(nums[i]);
                backtrack(size, i+1, comb);
                comb.removeLast();
            }
        }
    }
}