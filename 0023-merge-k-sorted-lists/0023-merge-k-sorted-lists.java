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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list!= null) {
                pq.add(list);
            }
        }
        
        ListNode res = new ListNode();
        ListNode p = res;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = new ListNode(node.val);
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return res.next;
    }
}