class Solution {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(this.nums);
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
                // if (i != start && nums[i-1] == nums[i]) {
                //     continue;
                // }
                if (i == start || nums[i-1] != nums[i]) {
                    comb.add(nums[i]);
                    backtrack(size, i+1, comb);
                    comb.removeLast();
                }
            }
        }
    }
};