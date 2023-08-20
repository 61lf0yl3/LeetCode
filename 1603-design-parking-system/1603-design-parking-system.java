class ParkingSystem {
    HashMap<Integer, Integer> map;
    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }
    
    public boolean addCar(int carType) {
        map.put(carType, map.get(carType)-1);
        return map.get(carType)>=0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */