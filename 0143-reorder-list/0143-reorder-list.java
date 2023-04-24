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
        
        ListNode second = slow.next;
        slow.next = null;
        // reverse mid
        ListNode reversed = null;
        while (second != null) {
            ListNode temp = new ListNode(second.val);
            temp.next = reversed;
            reversed = temp;
            second = second.next;
        }
        
        // combine
        ListNode first = head;
        second = reversed;
        while (second != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}