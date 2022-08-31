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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null, start=head, end=head, next=null, H=head;
        while(end!=null)
        {
            end=start;
            for(int c=1; c<k; c++) 
            {
                end=end.next;
                if(end==null) 
                {
                    prev.next=start;
                    return H;
                }
            }
            next=end.next;
            
            //reverse from start to end
            //System.out.println(start.val+" "+end.val);
            ListNode p=null, q=start, r=start.next;
            while(p!=end)
            {
                q.next=p;
                p=q;
                q=r;
                if(r!=null) r=r.next;
            }
            
            if(prev==null) H=end;
            else prev.next=end;
            prev=start;
            start=end=next;
        }
        return H;
    }
}