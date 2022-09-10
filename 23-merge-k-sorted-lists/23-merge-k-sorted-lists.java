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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode r=null, head=null;
        while(true)
        {
            boolean allNull=true;
            int min=0;
            for(int i=0; i<lists.length; i++)
            {
                if(lists[i]==null) continue;
                min=i;
                allNull=false;
            }
            if(allNull) break;
            for(int i=0; i<lists.length; i++)
            {
                if(lists[i]==null) continue;
                if(lists[i].val<lists[min].val) min=i;
            }
            if(r==null) head=r=lists[min];
            else
            {
                r.next=lists[min];
                r=r.next;
            }
            lists[min]=lists[min].next;
        }
        return head;
    }
}