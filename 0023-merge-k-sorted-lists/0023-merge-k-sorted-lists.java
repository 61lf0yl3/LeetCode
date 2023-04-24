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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            ListNode p = list;
            while (p != null) {
                pq.add(p.val);
                p = p.next;
            }
        }
        
        ListNode res = new ListNode();
        ListNode p = res;
        while (!pq.isEmpty()) {
            p.next = new ListNode(pq.poll());
            p = p.next;
        }
        return res.next;
    }
}