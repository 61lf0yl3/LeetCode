class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        
        longestStreak = 0;
        
        for num in nums:
            if (num-1) not in numSet:
                currentNum = num
                streak = 0
                while (currentNum in numSet):
                    streak += 1
                    currentNum += 1    
                longestStreak = max(longestStreak, streak)
        return longestStreak   