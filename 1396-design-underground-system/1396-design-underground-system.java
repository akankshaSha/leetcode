class CheckIn {
    String station;
    int time;
    CheckIn(String s, int t)
    {
        station = s;
        time = t;
    }
}

class CheckOut {
    double avg;
    int count;
    CheckOut ()
    {
        avg = 0.0;
        count = 0;
    }
    CheckOut (double a, int c)
    {
        avg = a;
        count = c;
    }
}

class UndergroundSystem {
    
    HashMap<Integer, CheckIn> customerCheckIn;
    HashMap<String, HashMap<String, CheckOut>> res;

    public UndergroundSystem() {
        customerCheckIn = new HashMap<>();
        res = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerCheckIn.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = customerCheckIn.get(id);
        
        if(!res.containsKey(checkIn.station)) res.put(checkIn.station, new HashMap<>());
        if(!res.get(checkIn.station).containsKey(stationName))
            res.get(checkIn.station).put(stationName, new CheckOut());
        
        CheckOut checkOut = res.get(checkIn.station).get(stationName);
        
        int count = checkOut.count;
        double t1 = checkOut.avg * count;
        double t2 = t - checkIn.time;
        double avg = (t1 + t2)/(1 + count);
        
        res.get(checkIn.station).put(stationName, new CheckOut(avg, count + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return res.get(startStation).get(endStation).avg;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */