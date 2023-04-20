class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        
        int startNew = newInterval[0];
        int endNew = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // new interval ends before start of current interval
            if ( endNew < interval[0]) {
                list.add(new int[]{startNew, endNew});
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                int[][] res = new int[list.size()][2];
                for (int j = 0; j < res.length; j++) {
                    res[j] = list.get(j);
                }
                return res;
            // new interval start after end of current interval
            } else if (startNew > interval[1]) {
                list.add(interval);
            } else {
                startNew = Math.min(startNew, interval[0]);
                endNew = Math.max(endNew, interval[1]);
            }
        }
        list.add(new int[]{startNew, endNew});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}