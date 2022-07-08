/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    static void merge(Node h1, Node t2)
    {
        t2.next=h1.next;
        if(h1.next!=null) h1.next.prev=t2;
        h1.next=h1.child;
        h1.child.prev=h1;
        h1.child=null;
    }
    static void dft(Node h1, Node h2)
    {
        Node t=h2;
        while(t!=null)
        {
            if(t.child!=null) dft(t, t.child);
            if(t.next==null)
            {
                if(h1==h2) return;
                merge(h1, t);
                return;
            }        
            t=t.next;
        }
    }
    public Node flatten(Node head)
    {
        dft(head, head);
        return head;
    }
}