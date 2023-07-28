class LRUCache {
    
    private class Node {
        private int key;
        private int value;

        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> map;
    
    private Node left;
    private Node right;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // make it most recent which is
            remove(map.get(key));
            insert(map.get(key));
            
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        
        if (map.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next =  node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void insert(Node node) {
        Node prev = right.prev;
        Node next = right;
        
        prev.next = node;
        node.next = next;
        
        next.prev = node;
        node.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */