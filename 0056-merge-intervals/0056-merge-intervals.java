class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        List<int[]> list = new ArrayList<>();
        int startNew = intervals[0][0];
        int endNew = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (endNew < interval[0]) {
                list.add(new int[]{startNew, endNew});
                startNew = interval[0];
                endNew = interval[1];
            } else if (interval[1] < startNew) {
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