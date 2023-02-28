class Solution {
    private Map<Integer, List<Integer>> m;
    private boolean[] seen;
    private boolean[] checked;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.m = new HashMap<>();
        this.seen = new boolean[numCourses];
        this.checked = new boolean[numCourses];
        
        for (int[] prerequisite : prerequisites) {
            if (!m.containsKey(prerequisite[0])) {
                m.put(prerequisite[0], new ArrayList<>());
            }
            m.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (isCyclic(currCourse)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isCyclic(int currCourse) {
        if (checked[currCourse]) {
            return false;
        }
        if (seen[currCourse]) {
            return true;
        }
        
        if (!m.containsKey(currCourse)) return false;
        
        seen[currCourse] = true;
        boolean res = false;
        for (int nextCourse : m.get(currCourse)) {
            res = isCyclic(nextCourse);
            if (res) {
                break;
            }
        }
        
        seen[currCourse] = false;
        
        checked[currCourse] = true;
        return res;
    }
}