class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> temp = new ArrayList<>(); 
        temp.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = temp.get(temp.size()-1);
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                temp.remove(temp.size()-1);
                temp.add(new int[]{prev[0], Math.max(prev[1],curr[1])});
            } else {
                temp.add(curr);
            }
        }
        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}