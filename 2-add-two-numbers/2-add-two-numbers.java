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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Zero=new ListNode();
        ListNode h1=l1;
        int sum=0,carry=0;
         while(l1!=null||l2!=null)
        {
            Zero=new ListNode();
            Zero.val=0;
            if(l1.next==null && l2.next!=null)
                l1.next=Zero;
            if(l2.next==null && l1.next!=null)
                l2.next=Zero;
            sum=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            l1.val=sum;
            l1=l1.next;
            l2=l2.next;
        }
        if(carry!=0)
        { 
            l1=h1;
            while(l1.next!=null)
                l1=l1.next;
            l1.next=new ListNode();
            l1.next.val=carry;
        }
        return h1;
        
    }
}