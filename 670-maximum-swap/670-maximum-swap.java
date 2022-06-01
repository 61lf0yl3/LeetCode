class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            char max = digits[i];
            int maxIndex = i;
            for (int j = i+1; j < n; j++) {
                if (digits[j] >= max) {
                    max = digits[j];
                    maxIndex = j;
                }
            }
            for (int j = 0; j < maxIndex; j++) {
                if (max > digits[j]) {
                    digits[maxIndex] = digits[j];
                    digits[j] = max;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}