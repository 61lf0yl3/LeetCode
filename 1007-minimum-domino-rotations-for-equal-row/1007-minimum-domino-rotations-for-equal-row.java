class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int swapsTops = check(tops, bottoms, tops[0]);
        if (swapsTops != -1 || tops[0] == bottoms[0]) {
            return swapsTops;
        } else {
            return check(tops, bottoms, bottoms[0]);
        }
    }
    
    private int check(int[] tops, int[] bottoms, int target) {
        int swapsTops = 0;
        int swapsBottoms = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                swapsTops++;
            } else if (bottoms[i] != target) {
                swapsBottoms++;
            }
        }
        return Math.min(swapsTops, swapsBottoms);
    }
}