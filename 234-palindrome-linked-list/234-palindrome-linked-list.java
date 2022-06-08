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
    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return recursivelyCheck(head);
    }
    
    private boolean recursivelyCheck(ListNode node) {
        if (node != null) {
            if (!recursivelyCheck(node.next)) {
                return false;
            }
            if (node.val != front.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    } 
}