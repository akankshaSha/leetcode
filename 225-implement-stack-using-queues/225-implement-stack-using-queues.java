class MyStack {
    
    Queue <Integer> q1;
    Queue <Integer> q2;
    int top;
    public MyStack() {
        q1= new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        top=x;
    }
    
    public int pop() {
        while(q1.size()>2) q2.add(q1.remove());
        top=q1.remove();
        if(q1.isEmpty()) return top;
        q2.add(top);
        int res=q1.remove();
        while(q2.size()>0) q1.add(q2.remove());
        return res;
    }
    
    public int top() {
       return top; 
    }
    
    public boolean empty() {
       return q1.isEmpty(); 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */