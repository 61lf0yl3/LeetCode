class Logger {
    Map<String, Integer> log;
    public Logger() {
        log = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (log.containsKey(message)) {
            if (log.get(message)+10 > timestamp) {
                return false;
            }
        }
        log.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */