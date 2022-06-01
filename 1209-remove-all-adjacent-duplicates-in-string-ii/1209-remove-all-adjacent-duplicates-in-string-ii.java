class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (!stack.isEmpty() && curr == stack.peek().getKey()) {
                Pair<Character, Integer> newPair = new Pair<>(curr, stack.peek().getValue()+1);
                stack.pop();
                stack.add(newPair);
            } else {
                stack.add(new Pair<>(curr, 1));
            }   
            if (stack.peek().getValue()==k) {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (Pair<Character, Integer> p : stack) {
            for (int i = 0; i < p.getValue(); i++) {
                res.append(p.getKey());
            }
        }
        return res.toString();
    }
}