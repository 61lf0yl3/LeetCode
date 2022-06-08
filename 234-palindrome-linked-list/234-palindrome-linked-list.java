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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            l.add(p.val);
            p = p.next;
        }
        p = head;
        for (int i = l.size() - 1; i >= l.size() / 2; i--) {
            if (l.get(i) != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}