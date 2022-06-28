class Solution {
   public boolean isPalindrome(String s) {
        int a = 0;
        int b = s.length()-1;
        while (a < b) {
            if (!Character.isAlphabetic(s.charAt(a)) &&
                !Character.isDigit(s.charAt(a))) {
                a++;
            } else if (!Character.isAlphabetic(s.charAt(b)) &&
                !Character.isDigit(s.charAt(b))) {
                b--;
            } else if (Character.toLowerCase(s.charAt(a))==Character.toLowerCase(s.charAt(b))) {
                a++;
                b--;
            } else {
                return false;
            }
        }
        return true;
    }
}