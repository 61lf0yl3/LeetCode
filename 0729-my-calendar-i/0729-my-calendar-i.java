class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        this.calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        List<int[]> calendar1 = calendar;
        calendar.sort((a, b) -> a[0] - b[0]);
        for (int[] event : calendar) {
            if ((event[0] <= start && start < event[1]) || (event[0] < end && end <= event[1]) ||
               (start < event[0] && event[1] < end)) {
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */