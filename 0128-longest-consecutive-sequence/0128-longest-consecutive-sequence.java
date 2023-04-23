class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int target = num+1;
                while (set.contains(target)) {
                    target++;;
                }
                res = Math.max(res, target-num);
            }
        }
        return res;
    }
}