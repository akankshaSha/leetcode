class MyQueue {
    Stack <Integer> s1;
    Stack <Integer> s2;
    int top;
    
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s1.size()==1) top=x;
    }
    
    public int pop() {
        while(s1.size()>2) s2.push(s1.pop());
        top=s1.pop();
        if(s1.isEmpty()) return top;
        s2.push(top);
        int res=s1.pop();
        while(s2.size()>0) s1.push(s2.pop());
        return res;
    }
    
    public int peek() {
       return top; 
    }
    
    public boolean empty() {
       return s1.isEmpty(); 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */