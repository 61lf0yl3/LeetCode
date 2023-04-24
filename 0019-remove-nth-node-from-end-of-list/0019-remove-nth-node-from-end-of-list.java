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
        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }
        
        ListNode res = new ListNode();
        res.next = head;
        p = res;
        int i = 0;
        while (i < size-n) {
            p = p.next;
            i++;
        }
        
        if (p.next != null) {
            p.next = p.next.next;
        } else {
            res = null;
        }
        return res.next;
    }
}