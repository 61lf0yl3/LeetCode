class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        double[] times = new double[target];
        
        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (double)(target-position[i])/speed[i];
        } 
        
        int res = 1;
        Stack<Double> prev = new Stack<>();
        for (int i = times.length-1; i >= 0; i--) {
            if (times[i] != 0) {
                if (prev.isEmpty()) {
                    prev.add(times[i]);
                } else if (prev.peek() < times[i]) {
                    prev.add(times[i]);
                }
            }
        }
        return prev.size();
    }
}