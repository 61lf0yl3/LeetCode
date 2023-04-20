class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0]-b[0];
        });
        
        int res = 0;
        int endNew = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            // if doesn't overla[]
            if ( interval[0] < endNew ) {
                endNew = Math.min(endNew, interval[1]);
                res++;
            } else {
                endNew = interval[1];
            }
        }
        
        return res;
    }
}