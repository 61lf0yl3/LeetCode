class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = [height[0]] * n
        right = [height[n-1]] * n
        
        for i in range(1, n-1):
            left[i] = max(height[i], left[i-1])
            right[n-i-1] = max(height[n-i-1], right[n-i])
        
        res = 0
        for i in range(1, n-1):
            res += min(left[i], right[i])-height[i]
            
        return res