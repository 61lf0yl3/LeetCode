class Solution {
private:
    unordered_map<int, vector<int>> m;
    unordered_set<int> seen;
    
    bool isCyclic(int currCourse) {
        if (seen.find(currCourse) != seen.end()) {
            return false;
        }
        if (m[currCourse].empty()) {
            return true;
        }
        
        seen.insert(currCourse);
        bool res = false;
        vector<int> tempList = m[currCourse];
        for (int i = 0; i < tempList.size(); i++) {
            int nextCourse = tempList[i];
            if (!isCyclic(nextCourse)) {
                return false;
            }
        }
        m[currCourse].clear();
        seen.erase(currCourse);
        
        return true;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        for (int i = 0; i < prerequisites.size(); i++) {
            m[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        
        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (!isCyclic(currCourse)) {
                return false;
            }
        }
        
        return true;
    }
};