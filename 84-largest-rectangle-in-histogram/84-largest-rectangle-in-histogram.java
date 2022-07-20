class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {                                 int[] histogram = stack.pop();
                index = histogram[0];
                int area = (i-histogram[0])*histogram[1];
                res = Math.max(res, area);
            }
            stack.add(new int[]{index, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] histogram = stack.pop();
            int area = (n-histogram[0])*histogram[1];
            res = Math.max(res, area);
        }
        return res;
    }
}