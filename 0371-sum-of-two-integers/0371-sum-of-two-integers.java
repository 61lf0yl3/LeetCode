class Solution {
    public int getSum(int a, int b) {
        int xor = a^b;
        int reminder = (a&b) << 1;
        while (reminder != 0) {
            int temp = xor^reminder;
            reminder = (xor&reminder) << 1;
            xor = temp;
        }
        return xor;
    }
}