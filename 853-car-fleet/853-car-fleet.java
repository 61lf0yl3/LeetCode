class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }
        
        Arrays.sort(combined, (a, b) -> b[0]-a[0]);
        
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = (double)(target-combined[i][0])/combined[i][1];
            //double time=(double)(target-combined[i][0])/combined[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.add(time);
            }
        }
        
        return stack.size();
    }
}