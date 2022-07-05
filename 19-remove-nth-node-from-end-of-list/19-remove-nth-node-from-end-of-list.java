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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast=head;
        for (int i=1; i<=n; i++)
        {
            if (fast.next==null)
            {
                return head.next;
            }
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        if(slow.next==null) slow=null;
        slow.next=slow.next.next;
        return head;
    }
}