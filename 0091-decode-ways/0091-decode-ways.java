class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            int twodigit = Integer.parseInt(s.substring(i-2, i));
            if (10 <= twodigit && twodigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];
    }
}