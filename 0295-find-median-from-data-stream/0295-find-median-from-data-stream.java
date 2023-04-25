class MedianFinder {
    
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // System.out.println(left);
        // System.out.println(right);
        if (!right.isEmpty() && right.peek() < num) {
            right.add(num);
        } else {
            left.add(num);
        }
        
        // System.out.println(left);
        // System.out.println(right);
        
        if (left.size() < right.size()) {
            left.add(right.poll());
        } else if (left.size() > right.size()+1) {
            right.add(left.poll());
        }
        // System.out.println(left);
        // System.out.println(right);
    }
    
    public double findMedian() {
        // System.out.println(left);
        // System.out.println(right);
        if (left.size() == right.size()) {
            return (double)(left.peek()+right.peek())/2;
        } else {
            return (double)left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */