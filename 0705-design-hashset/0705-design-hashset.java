class MyHashSet {
    private int base;
    private Bucket[] bucketList;
    public MyHashSet() {
        this.base = 769;
        this.bucketList = new Bucket[base];
        
        for (int i = 0; i < base; i++) {
            bucketList[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int bucketIndex = key%base;
        bucketList[bucketIndex].add(key);
    }
    
    public void remove(int key) {
        int bucketIndex = key%base;
        bucketList[bucketIndex].remove(key);
    }
    
    public boolean contains(int key) {
        int bucketIndex = key%base;
        return bucketList[bucketIndex].contains(key);
    }
    
    private class Bucket {
        private LinkedList<Integer> bucket;
        public Bucket() {
            bucket = new LinkedList<>();
        }
        
        private void add(int key) {
            int index = bucket.indexOf(key);
            // if doen't exist;
            if (index == -1) {
                bucket.add(key);
            }
        }
        
        private void remove(Integer key) {
            bucket.remove(key);
        }
        
        private boolean contains(int key) {
            int index = bucket.indexOf(key);
            return index!=-1;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */