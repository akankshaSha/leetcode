class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> keyValues;
    public TimeMap() {
        keyValues=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> values=keyValues.getOrDefault(key, new ArrayList<>());
        values.add(new Pair(timestamp, value));
        keyValues.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values=keyValues.get(key);
        if(values==null) return "";
        return search(values, timestamp);
    }
    
    String search(List<Pair<Integer, String>> values, int target)
    {
        int left=0, right=values.size()-1, mid=0;
        while(left<=right)
        {
            mid=(left+right)/2;
            int s=values.get(mid).getKey();
            if(s>target) right=mid-1;
            else if(s<target) left=mid+1;
            else return values.get(mid).getValue();
        }
        if(values.get(mid).getKey() > target)
        {
            if(mid==0) return "";
            return values.get(mid-1).getValue();
        }
        return values.get(mid).getValue();
    }
}