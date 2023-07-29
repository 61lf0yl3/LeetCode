class RandomizedSet {
    private List<Integer> arr;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        List<Integer> arr1 = arr;
        Map<Integer, Integer> map1 = map;
        
        if (!map.containsKey(val)) {
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        List<Integer> arr1 = arr;
        Map<Integer, Integer> map1 = map;
        
        if (map.containsKey(val)) {
            int index = map.get(val);
            int value = arr.get(arr.size()-1);
            
            arr.set(index, value);
            map.put(value, index);
            
            map.remove(val);
            arr.remove(arr.size()-1);
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        List<Integer> arr1 = arr;
        Map<Integer, Integer> map1 = map;

        Random rand = new Random();
        int num = rand.nextInt(arr.size());
        return arr.get(num);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */