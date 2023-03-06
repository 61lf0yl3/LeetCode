class Solution {
    static final int WHITE = 1;
    static final int GRAY = 2;
    static final int BLACK = 3;
    
    private Map<Integer, List<Integer>> m;
    boolean isPossible;
    private Map<Integer, Integer> color;
    private ArrayList<Integer> path;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.m = new HashMap<>();
        this.isPossible = true;
        this.color = new HashMap<>();
        this.path = new ArrayList<>();
        
        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
        
        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            if (!m.containsKey(prerequisite[1])) {
                m.put(prerequisite[1], new ArrayList<>());
            }
            m.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // If the node is unprocessed, then call dfs on it.
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (color.get(currCourse) == WHITE) {
                isCyclic(currCourse);
            }
        }
        
        int[] res = new int[0];
        if (isPossible) {
            res = new int[path.size()];
            for (int i = 0; i < path.size(); i++) {
                res[i] = path.get(path.size()-1-i);
            }
        }
        
        return res;
    }
    
    private void isCyclic(int currCourse) {
        
        if (!isPossible) {
            return;
        }
        
        color.put(currCourse, GRAY);
        
        for (int nextCourse : m.getOrDefault(currCourse, new ArrayList<Integer>())) {
            if (color.get(nextCourse) == WHITE) {
                isCyclic(nextCourse); 
            } else if (color.get(nextCourse) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
            
        }
        color.put(currCourse, BLACK);
        path.add(currCourse);
    }
}