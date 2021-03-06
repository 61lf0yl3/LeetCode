class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        for (int i = 0; i < n - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                char max = digits[i + 1];
                int maxIndex = i + 1;
                for (int j = i + 1; j < n; j++) {
                    if (digits[j] >= max) {
                        max = digits[j];
                        maxIndex = j;
                    }
                }
                for (int j = 0; j <= i; j++) {
                    if (max > digits[j]) {
                        digits[maxIndex] = digits[j];
                        digits[j] = max;
                        return Integer.parseInt(new String(digits));
                    }
                }
            }
        }
        return num;
    }
}