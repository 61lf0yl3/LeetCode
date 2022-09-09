class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backtrack(comb = [], open = 0, close=0):
            if len(comb) == 2*n:
                res.append("".join(comb))
                return
            if open < n:
                comb.append("(")
                backtrack(comb, open+1, close)
                comb.pop()
            if close < open:
                comb.append(")")
                backtrack(comb, open, close+1)
                comb.pop()
        backtrack()
        return res