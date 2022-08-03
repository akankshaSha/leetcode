class Event
{
    int start;
    int end;
    Event(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}

class MyCalendar {
    HashSet<Event> events;
    public MyCalendar() {
        events=new HashSet<>();
    }
    
    public boolean book(int start, int end) {
        for(Event event: events)
        {
            boolean before= start<event.start && end<=event.start;
            boolean after= start>=event.end && end>=event.end;
            if(!(before || after)) return false;
        }
        events.add(new Event(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */