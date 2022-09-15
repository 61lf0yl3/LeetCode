class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> res(n);
        stack<int> stack;
        
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(i);
            } else {
                while (!stack.empty() && temperatures[stack.top()] < temperatures[i]) {
                    int j = stack.top(); 
                    res[j] = i-j;
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
};