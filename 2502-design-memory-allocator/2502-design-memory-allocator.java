class Allocator {
    private int[] memory; 
    
    public Allocator(int n) {
        memory = new int[n]; 
    }
    
    public int allocate(int size, int mID) {
        int free = 0; 
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == 0) {
                free++;
                if (free == size) {
                    for (int j = i; j >= i-size+1; j--) 
                        memory[j] = mID; 
                    return i-size+1; 
                }
            } else free = 0; 
        }
        return -1; 
    }
    
    public int free(int mID) {
        int res = 0; 
        for (int i = 0; i < memory.length; ++i) 
            if (memory[i] == mID) {
                res++; 
                memory[i] = 0; 
            }
        return res; 
    }
}