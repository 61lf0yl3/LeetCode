class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left = [1] * n
        
        right = [1] * n
        
        for i in range(1, n):
            left[i] = nums[i-1]*left[i-1]
            right[n-i-1] = nums[n-i]*right[n-i]
            
        res = [1] * n
        for i in range(n):
            res[i] = left[i]*right[i]
            
        return res