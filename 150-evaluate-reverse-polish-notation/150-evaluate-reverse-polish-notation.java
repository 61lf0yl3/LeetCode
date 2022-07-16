class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            
            if (str.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.add(num1+num2);
            } else if (str.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.add(num1-num2);
            } else if (str.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.add(num1*num2);
            } else if (str.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.add(num1/num2);
            } else {
                stack.add(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}