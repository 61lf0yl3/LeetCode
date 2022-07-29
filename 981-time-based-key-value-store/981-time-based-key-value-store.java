class TimeMap {

    HashMap<String, ArrayList> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new ArrayList<>());
        }
        m.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (m.containsKey(key)) {
            ArrayList<Pair<String, Integer>> list = m.get(key);
            int low = 0;
            int high = list.size()-1;
            if (list.get(low).getValue() > timestamp) {
                return "";
            }
            if (list.get(high).getValue() <= timestamp) {
                return list.get(high).getKey();
            }
            while (low < high) {
                int mid = low + (high-low)/2;
                if (list.get(low).getValue() < list.get(mid).getValue()) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return list.get(low).getKey();
        } 
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */