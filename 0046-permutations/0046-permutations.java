class Solution {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        backtrack(new LinkedList<>(), 0);
        return res;
    }
    
    private void backtrack(LinkedList<Integer> comb, int start) {
        if (comb.size() == nums.length) {
            res.add(new LinkedList<>(comb));
        } else {
            for (int i = start; i < nums.length; i++) {
                comb.add(nums[i]);
                
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;

                backtrack(comb, start+1);
                
                nums[start] = nums[i];
                nums[i] = temp;
                
                comb.removeLast();
            }
        }
    }
}