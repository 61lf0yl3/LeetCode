class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (!stack.isEmpty() && curr == stack.peek().getKey()) {
                int repeat = stack.pop().getValue() + 1;
                if (repeat < k) {
                    stack.add(new Pair<>(curr, repeat));
                }
            } else {
                stack.add(new Pair<>(curr, 1));
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