class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if (!map.containsKey(edge[1])) {
                 map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        int res = 0;
        boolean[] checked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                res++;
                backtrack(map, i, checked, new boolean[n]);
            }
            checked[i] = true;
        }
        return res;
    }
    
    private void backtrack(Map<Integer, List<Integer>> map, int i, boolean[] checked, boolean[] seen) {
        if (checked[i]) {
            return;
        }
        checked[i] = true;
        if (!map.containsKey(i)) {
            return;
        }
        if (seen[i]) {
            return;
        }
        seen[i] = true;
        List<Integer> edges = map.get(i);
        for (int edge : edges) {
            backtrack(map, edge, checked, seen);
        }
        seen[i] = false;
    }
}