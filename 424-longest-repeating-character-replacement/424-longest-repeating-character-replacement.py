class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0;
        right = 0;
        freqChar = 0;
        chars = {}
        res = 0
        while (right < len(s)):
            chars[s[right]] = 1 + chars.get(s[right], 0)
            freqChar = max(freqChar, chars[s[right]])
            
            if right-left+1-freqChar <= k:
                res = max(res, right-left+1)
            else:
                chars[s[left]] -= 1
                left += 1
            right += 1
        
        return res
            