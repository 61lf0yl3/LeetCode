class Trie {
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a']== null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.endWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a']== null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.endWord == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c-'a']== null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
    
    
    class TrieNode {
        private TrieNode[] children;
        private boolean endWord;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.endWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */