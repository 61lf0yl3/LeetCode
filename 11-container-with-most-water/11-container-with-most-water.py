class Solution:
    def maxArea(self, height: List[int]) -> int:
        low = 0
        high = len(height)-1
        res = 0
        while (low < high):
            vol = (high-low)*min(height[low], height[high])
            res = max(res, vol)
            if height[low] < height[high]:
                low += 1
            else:
                high -= 1
        
        return res