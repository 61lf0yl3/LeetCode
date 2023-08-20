class Allocator {
    int[] memory;
    public Allocator(int n) {
        this.memory = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int[] memory1 = memory;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == 0) {
                int available = 0;
                for (int j = i; j < memory.length; j++) {
                    if (memory[j] == 0) {
                        available++;
                        if (available == size) {
                            break;
                        }
                    } else {
                        break;
                    }
                    
                }
                if (available == size) {
                    for (int j = i; j < i+size; j++) {
                        memory[j] = mID;
                    }
                    return i;
                }
                
            }
        }
        return -1;
    }
    
    public int free(int mID) {
        int res = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = 0;
                res++;
            }
        }
        return res;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */