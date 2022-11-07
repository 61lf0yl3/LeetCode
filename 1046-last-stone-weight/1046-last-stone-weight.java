class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int stone : stones) {
            q.add(-stone);
        }
        while (q.size() > 1) {
            q.add(-Math.abs(q.poll()-q.poll()));
        }
        
        return Math.abs(q.poll());
    }
}