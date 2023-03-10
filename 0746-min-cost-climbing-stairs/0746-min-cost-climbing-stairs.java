class Solution {
    int[] cost;
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.memo = new int[cost.length+1];
       
        return dfs(cost.length);
    }
    
    private int dfs(int i) {
        if (i < 2) {
            return 0;
        }
        if (memo[i] == 0) {
            memo[i] = Math.min(dfs(i-1)+cost[i-1], dfs(i-2)+cost[i-2]);
        }
        return memo[i];
    }
}