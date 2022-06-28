class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int res = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum+1)) {
                    currentStreak++;
                    currentNum++;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }
}