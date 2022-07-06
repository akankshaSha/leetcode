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
    static ListNode newHead;
    public ListNode rev(ListNode node)
    {
        if(node.next==null)
        {
            newHead=node;
            return node;
        }
        ListNode nextNode=rev(node.next);
        nextNode.next=node;
        node.next=null;
        return node;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        rev(head);
        return newHead;
    }
}