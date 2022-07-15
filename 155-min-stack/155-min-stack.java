class MinStack {
    private Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new int[]{val, val});
        } else {
            int[] temp = stack.peek();
            stack.add(new int[]{val, Math.min(val, temp[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int[] temp = stack.peek();
        return temp[0];
    }
    
    public int getMin() {
        int[] temp = stack.peek();
        return temp[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */