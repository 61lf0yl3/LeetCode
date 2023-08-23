class MyHashMap {
    Bucket[] list;
    int base;
    public MyHashMap() {
        base = 769;
        list = new Bucket[base];
        for (int i = 0; i < 769; i++) {
            list[i] = new Bucket();
        }
    }
    
    public void put(int key, int value) {
        int index = key%base;
        list[index].put(key, value);
    }
    
    public int get(int key) {
        int index = key%base;
        return list[index].get(key);
    }
    
    public void remove(int key) {
        int index = key%base;
        list[index].remove(key);
    }
    
    private class Bucket {
        List<int[]> list;
        public Bucket() {
            list = new ArrayList<>();
        }
        
        private int getIndex(int key) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0]==key) {
                    return i;
                }
            }
            return -1;
        }
        private void put(int key, int value) {
            int index = getIndex(key);
            if (index == -1) {
                list.add(new int[]{key, value});
            } else {
                list.set(index, new int[]{key, value});
            }
        }

        private int get(int key) {
            int index = getIndex(key);
            if (index == -1) {
                return -1;
            }
            return list.get(index)[1];
        }

        private void remove(int key) {
            int index = getIndex(key);
            if (index != -1) {
                list.remove(index);
            }
        }
      
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */