class Bitset {
    
    boolean bits[];
    int set = 0;
    int flipCount = 0;

    public Bitset(int size) {
        bits = new boolean[size];
    }
    
    public void fix(int idx) {
        boolean val = flipCount % 2 == 0;
        if(bits[idx] == !val) set++;
        bits[idx] = val;
    }
    
    public void unfix(int idx) {
        boolean val = flipCount % 2 == 0;
        if(bits[idx] == val) set--;
        bits[idx] = !val;
    }
    
    public void flip() {
        flipCount++;
        set = bits.length - set;
    }
    
    public boolean all() {
        return set == bits.length;
    }
    
    public boolean one() {
        return set > 0;
    }
    
    public int count() {
        return set;
    }
    
    public String toString() {
        char res[] = new char[bits.length];
        if(flipCount % 2 !=0)
        {
            for(int i = 0; i<bits.length; i++) bits[i] = !bits[i];
        }
        flipCount = 0;
        for(int j =0; j<bits.length; j++) res[j] = bits[j]?'1':'0';
        return new String(res);
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */