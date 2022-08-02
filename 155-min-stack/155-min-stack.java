class MinStack {
    int stack[];
    int min[];
    int top=-1;
    public MinStack() {
        stack=new int[30000];
        min=new int[30000];
    }
    
    public void push(int val) {
        stack[++top]=val;
        if(top==0) min[top]=val;
        else min[top]=Math.min(min[top-1], val);
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return min[top];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */