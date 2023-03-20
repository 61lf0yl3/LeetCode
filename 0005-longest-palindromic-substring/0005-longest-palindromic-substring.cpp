class Solution {
public:
    string longestPalindrome(string s) {
        this->s = s;
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int retSize = expandPalindrome(i, i);
            retSize = max(retSize, expandPalindrome(i, i+1));
            
            if (retSize > end-start) {
                start = i - (retSize-1)/2;
                end = i + retSize/2;
            }
        }
        
        return s.substr(start, end-start+1);
    }
    
private:
    string s;
    int expandPalindrome(int start, int end) {
        int L = start, R = end;
        while (L >= 0 && R < s.length() && s[L] == s[R]) {
            L--;
            R++;
        }
        return R - L - 1;
    }
};