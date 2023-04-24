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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        
        ListNode p = head;
        while (p != null) {
            ListNode temp = new ListNode(p.val);
            temp.next = res;
            res = temp;
            p = p.next;
        }
        
        return res;
    }
}