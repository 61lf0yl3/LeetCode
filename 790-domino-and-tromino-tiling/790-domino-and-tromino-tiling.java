class Solution {
    int MOD = 1000000007;
    Map<Integer, Long> fullMap = new HashMap<>();
    Map<Integer, Long> partiallyMap = new HashMap<>();
    public int numTilings(int n) {
        return (int)fullCovered(n)%MOD;
    }
    
    private long fullCovered(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (!fullMap.containsKey(n)) {
            long val = fullCovered(n-1) + fullCovered(n-2) + 2*partiallyCovered(n-1);
            fullMap.put(n, val%MOD);
        }
        return fullMap.get(n);
    }
    
    private long partiallyCovered(int n) {
        if (n==2) {
            return 1;
        }
        if (!partiallyMap.containsKey(n)) {
            long val = partiallyCovered(n-1) + fullCovered(n-2);
            partiallyMap.put(n, val%MOD);
        }
        return partiallyMap.get(n);
    }
}