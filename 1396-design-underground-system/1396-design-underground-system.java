class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> ids;
    private Map<String, Pair<Integer, Double>> stations;
    public UndergroundSystem() {
        ids = new HashMap<>();
        stations = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        ids.put(id, new Pair<>(stationName+"-", t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = ids.get(id);
        String twoStation = pair.getKey()+stationName;
        if (stations.containsKey(twoStation)) {
            Pair<Integer, Double> temp = stations.get(twoStation);
            stations.put(twoStation, new Pair(temp.getKey()+t-pair.getValue(),temp.getValue()+1));
        } else {
            stations.put(twoStation, new Pair(t-pair.getValue(), 1.0));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Double> pair =  stations.get(startStation+"-"+endStation);
        return pair.getKey()/pair.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */