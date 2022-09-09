class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == "+":
                stack.append(stack.pop() + stack.pop());
            elif token == "-":
                stack.append(-stack.pop() + stack.pop());
            elif token == "*":
                stack.append(stack.pop() * stack.pop());
            elif token == "/":
                nb2, nb1 = stack.pop(), stack.pop()
                stack.append(int(nb1/nb2));
            else:
                stack.append(int(token))
        
        return stack.pop()