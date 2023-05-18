class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            while (stack.peek() != -1 && curr <= heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                res = Math.max(res, currentHeight*(i-stack.peek()-1));
            }
            stack.add(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            res = Math.max(res, currentHeight*(heights.length-stack.peek()-1));
        }
        return res;
    }
}