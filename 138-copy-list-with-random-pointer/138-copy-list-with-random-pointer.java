/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node t;
        t=head;
        while(t!=null)
        {
            Node temp=new Node(t.val);
            temp.next=t.next;
            t.next=temp;
            t=t.next.next;
        }
        
        t=head;
        while(t!=null)
        {
            if(t.random!=null)
                t.next.random=t.random.next;
            t=t.next.next;
        }
        
        Node copyHead=head.next;
        head.next=head.next.next;
        t=head.next;
        Node r=copyHead;
        while(t!=null)
        {
            r.next=t.next;
            t.next=t.next.next;
            r=r.next;
            t=t.next;
        }
        
        return copyHead;
    }
}