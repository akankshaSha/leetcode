class RandomizedSet {
    Set <Integer> randomSet;

    public RandomizedSet() {
        randomSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return randomSet.add(val);
    }
    
    public boolean remove(int val) {
        if(randomSet.contains(val))
        {
            randomSet.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Iterator set = randomSet.iterator();
        int stop = (int) (Math.random() * randomSet.size());
        int res = 0;
        while(set.hasNext())
        {
            res = (int) set.next();
            if(stop == 0) break;
            stop --;
        }
        return res;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */