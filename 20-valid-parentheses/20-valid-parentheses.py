class Solution:
    def isValid(self, s: str) -> bool:
        mapping = { ")": "(", "}":"{", "]":"["}
        stack = []
        for c in s:
            if not c in mapping:
                stack.append(c)
            else:
                if len(stack) > 0 and stack[-1] == mapping[c]:
                    stack.pop()
                else:
                    return False
        
        return len(stack)==0
            