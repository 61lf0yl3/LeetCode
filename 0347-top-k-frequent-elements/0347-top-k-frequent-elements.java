class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] res = new int[k];
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        // for (int num : map.keySet()) {
        //     pq.add(num);
        // }
        // for (int i = 0; i < k; i++) {
        //     res[i] = pq.poll();
        // }
        
        // safe on space
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));
        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = k-1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
    
    
}