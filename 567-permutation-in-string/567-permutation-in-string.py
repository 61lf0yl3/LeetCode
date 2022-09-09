class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        chars = [0] * 26;
        for i in range(len(s1)):
            chars[ord(s1[i])-ord('a')] += 1
            
        left = 0
        right = 0
        
        while (right < len(s2)):
            if chars[ord(s2[right])-ord('a')] == 0:
                chars[ord(s2[left])-ord('a')] += 1
                left += 1
                continue
            else:
                chars[ord(s2[right])-ord('a')] -= 1
                if right-left+1 == len(s1):
                    return True
            right += 1
            
        return False