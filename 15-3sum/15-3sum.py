class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        
        for i, v in enumerate(nums):
            if v > 0:
                continue
            if i > 0 and v == nums[i-1]:
                continue
            
            low = i+1
            high = len(nums)-1
            while (low < high):
                sum = v + nums[low] + nums[high]
                if sum == 0:
                    res.append([v, nums[low], nums[high]])
                    low += 1
                    while nums[low] == nums[low-1] and low < high:
                        low += 1
                elif sum < 0:
                    low += 1
                else:
                    high -= 1
        
        return res