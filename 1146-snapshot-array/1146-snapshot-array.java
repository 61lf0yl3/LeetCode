class SnapshotArray {
    private int id;
    Map<Integer, Integer>[] map;
    int length;
    Map<Integer, Integer> curr;
    public SnapshotArray(int length) {
        id = 0;
        map = new HashMap[length];
        for (int i = 0; i < length; i++) {
            map[i] = new HashMap<>();
        }
        curr = new HashMap<>();
    }
    
    public void set(int index, int val) {
        curr.put(index, val);
    }
    
    public int snap() {
        for (int index : curr.keySet()) {
            map[index].put(id, curr.get(index));
        }
        curr = new HashMap<>();
        return id++;
    }
    
    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (map[index].containsKey(snap_id)) {
                return map[index].get(snap_id);
            }
            snap_id--;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */