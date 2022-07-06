class Node
{
    int val;
    Node next;
    Node()
    {
        val=0;
        next=null;
    }
    Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}

class MyLinkedList {
    Node head, tail;
    public MyLinkedList() {
        head=null;
        tail=null;
    }
    
    public int get(int index) {
        Node temp=head;
        for(int i=0; i<index; i++)
        {
            if(temp==null) return -1;
            temp=temp.next;
        }
        if(temp==null) return -1;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node=new Node(val);
        if(head==null) head=tail=node;
        else
        {
            node.next=head;
            head=node;
        }
    }
    
    public void addAtTail(int val) {
        Node node=new Node(val);
        if(tail==null) head=tail=node;
        else
        {
            tail.next=node;
            tail=node;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0) 
        {
            addAtHead(val);
            return;
        }
        Node t=head;
        for(int i=0; i<index-1; i++)
        {
            if(t.next==null) break;
            t=t.next;
        }
        if(t==null) return;
        if(t==tail)
        {
            addAtTail(val);
            return;
        }
        Node node=new Node(val);
        node.next=t.next;
        t.next=node;
    }
    
    public void deleteAtIndex(int index) {
        if(index==0)
        {
            head=head.next;
            return;
        }
        Node t=head;
        for(int i=0; i<index-1; i++)
        {
            if(t.next==null) return;
            t=t.next;
        }
        if(t.next==null) return;
        if(t.next==tail) tail=t;
        t.next=t.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */