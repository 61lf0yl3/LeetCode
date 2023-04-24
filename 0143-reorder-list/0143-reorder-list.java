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
        ListNode slow = head;
        ListNode fast = head;
        // find the middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse mid
        ListNode reversed = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            
            curr.next = reversed;
            reversed = curr;
            curr = temp;
        }
        
        // combine
        ListNode first = head;
        ListNode second = reversed;
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}