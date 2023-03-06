class Solution {
    private Map<Integer, List<Integer>> m;
    private boolean[] seen;
    private boolean[] checked;
    private ArrayList<Integer> path;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.m = new HashMap<>();
        this.seen = new boolean[numCourses];
        this.checked = new boolean[numCourses];
        this.path = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            if (!m.containsKey(prerequisite[1])) {
                m.put(prerequisite[1], new ArrayList<>());
            }
            m.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (isCyclic(currCourse)) {
                return new int[0];
            }
        }
        
        int[] res = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            res[i] = path.get(path.size()-1-i);
        }
        return res;
    }
    
    private boolean isCyclic(int currCourse) {
        if (checked[currCourse]) {
            return false;
        }
        if (seen[currCourse]) {
            return true;
        }
        
        // if (!m.containsKey(currCourse)) return false;
        
        seen[currCourse] = true;
        boolean res = false;
        for (int nextCourse : m.getOrDefault(currCourse, new ArrayList<>())) {
            res = isCyclic(nextCourse);
            if (res) {
                break;
            }
        }
        
        path.add(currCourse);
        seen[currCourse] = false;
        
        checked[currCourse] = true;
        return res;
    }
}