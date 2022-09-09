class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if len(stack) > 0 and (c == ')' and stack[-1]=='(' or 
                                       (c == '}' and stack[-1]=='{') or 
                                       (c == ']' and stack[-1]=='[')):
                    stack.pop()
                else:
                    return False
        
        return len(stack)==0
            