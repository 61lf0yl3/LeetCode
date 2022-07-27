class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        while (low < high) {
            int mid = low + (high-low)/2;
            int hourSpent = 0;
            for (int pile : piles) {
                hourSpent += pile/mid;
                if (pile%mid > 0) {
                    hourSpent++;
                } 
            }
            if (hourSpent > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}