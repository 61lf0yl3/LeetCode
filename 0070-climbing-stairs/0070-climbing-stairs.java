class Solution {
    int[] memo;
    int n;
    public int climbStairs(int n) {
        this.n = n;
        memo = new int[n+1];
        return dp(n);
    }

    public int dp(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (memo[i] == 0) {
            memo[i] = dp(i - 1) + dp(i - 2);
        }
        return memo[i];
    }
}