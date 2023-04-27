class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                res++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}



//         Arrays.sort(intervals, (int[] a, int[] b) -> {
//             return a[0]-b[0];
//         });
        
//         int res = 0;
//         int endNew = intervals[0][1];
        
//         for (int i = 1; i < intervals.length; i++) {
//             int[] interval = intervals[i];
            
//             // if prev and curr overlap pick end smaller, and one of them gonna deleted
//             if ( interval[0] < endNew ) {
//                 endNew = Math.min(endNew, interval[1]);
//                 res++;
//             } else {
//             // update the end
//                 endNew = interval[1];
//             }
//         }
        
//         return res;