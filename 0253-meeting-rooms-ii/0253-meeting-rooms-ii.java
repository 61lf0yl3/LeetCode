class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> ends = new PriorityQueue<>((a, b) -> a-b);
        
        ends.add(intervals[0][1]);
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            // if previous meeting ends before the start of current meeting 
            if (!ends.isEmpty() && ends.peek() <= intervals[i][0]) {
                while (!ends.isEmpty() && ends.peek() <= intervals[i][0]) {
                    ends.poll();
                }
            }
            // if no meeting room is emptied the add new room meeting    
            ends.add(intervals[i][1]);
            res = Math.max(res, ends.size());
        }
        return res;
    }
}