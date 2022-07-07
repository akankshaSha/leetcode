/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static int getSize(ListNode head)
    {
        ListNode t=head;
        int l=0;
        while(t!=null)
        {
            l++;
            t=t.next;
        }
        return l;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int size=getSize(head);
        k%=size;
        ListNode t=head;
        for(int i=1; i<size-k; i++) t=t.next;
        ListNode tail=t;
        while(tail.next!=null) tail=tail.next;
        tail.next=head;
        head=t.next;
        t.next=null;
        return head;
    }
}