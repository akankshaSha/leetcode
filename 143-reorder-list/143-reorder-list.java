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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode n=head;
        while(n!=null)
        {
            stack.push(n);
            n=n.next;
        }
        n=head;
        while(!stack.empty())
        {
            ListNode m=stack.pop();
            if(m==n || m==n.next) break;
            m.next=n.next;
            n.next=m;
            if(!stack.empty()) stack.peek().next=null;
            n=n.next.next;
        }
    }
}