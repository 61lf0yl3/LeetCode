class BrowserHistory {
    private List<String> history;
    private int total;
    private int current;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        total = 0;
        current = 0;
        visit(homepage);
    }
    
    public void visit(String url) {
        if (current < history.size()) {
           history.set(current, url); 
        } else {
            history.add(url);
        }
        current++;
        total = current;
    }
    
    public String back(int steps) {
        current = Math.max(1, current-steps);
        return history.get(current-1);
    }
    
    public String forward(int steps) {
        current = Math.min(total, current+steps);
        return history.get(current-1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */