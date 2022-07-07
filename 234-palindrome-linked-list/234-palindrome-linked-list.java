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
    
    public ListNode reversedFromNode(ListNode node)
    {
        if(node==null) return null;
        ListNode p=null, q=node, r=node.next;
        while(r!=null)
        {
            q.next=p;
            p=q;
            q=r;
            r=r.next;
        }
        q.next=p;
        return q;
    }
    
    public boolean isPalindrome(ListNode head) 
    {
        if(head.next==null) return true;
        int l=0;
        ListNode t=head;
        while(t!=null)
        {
            l++;
            t=t.next;
        }
        int h=l/2;
        t=head;
        while(h>1)
        {
            t=t.next;
            h--;
        }
        ListNode newHead;
        if(l%2==0)
        {
           newHead=reversedFromNode(t.next); 
        }
        else
        {
            newHead=reversedFromNode(t.next.next);
            t.next=null;
        }
        while(newHead!=null)
        {
            if(head.val!=newHead.val) return false;
            head=head.next;
            newHead=newHead.next;
        }
        return true;
    }
}