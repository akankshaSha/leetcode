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
    public int getDecimalValue(ListNode head) {
        String binaryNumber="";
        while(head!=null)
        {
            binaryNumber+=head.val;
            head=head.next;
        }
        int num=0;
        for(int i=0; i<binaryNumber.length(); i++)
        {
            if(binaryNumber.charAt(i)=='1')
                num+=Math.pow(2, binaryNumber.length()-1-i);
        }
        return num;
    }
}