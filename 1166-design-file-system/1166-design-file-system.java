class FileSystem {
    
    private class Trie {
        private int value;
        private String name;
        private Map<String, Trie> children;
        
        public Trie(String name) {
            this.name = name;
            this.value = -1;
            this.children = new HashMap<>();
        }
    }
    
    private Trie root;
    public FileSystem() {
        this.root = new Trie("");
    }
    
    public boolean createPath(String path, int value) {
        String[] files = path.split("/");
        
        Trie current = root;
        
        for (int i = 1; i < files.length; i++) {
            if (!current.children.containsKey(files[i])) {
                if (i == files.length-1) {
                    current.children.put(files[i], new Trie(files[i]));
                } else {
                    return false;
                }
            }
            current = current.children.get(files[i]);
        }
        if (current.value != -1) {
            return false;
        }
        current.value = value;
        return true;
    }
    
    public int get(String path) {
        String[] files = path.split("/");
        
        Trie current = root;
        for (int i = 1; i < files.length; i++) {
            if (!current.children.containsKey(files[i])) {
                return -1;
            }
            current = current.children.get(files[i]);   
        }
        return current.value; 
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */