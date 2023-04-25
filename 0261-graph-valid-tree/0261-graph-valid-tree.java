class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0 && n == 1) {
            return true;
        }
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
        Set<Integer> seen = new HashSet<>();
        return dfs(map, 0, -1, seen) && seen.size() == n;
    }
    
    
    private boolean dfs(Map<Integer, List<Integer>> map, int node, int parent,  Set<Integer> seen) {
        if (seen.contains(node)) {
            return false;
        }
        if (!map.containsKey(node)) {
            return true;
        }
        seen.add(node);
        List<Integer> list = map.get(node);
        for (int neighbour : list) {
            if (parent != neighbour) {
                if (!dfs(map, neighbour, node, seen)) {
                    return false;
                }
            }
        }
        return true;
    }
}