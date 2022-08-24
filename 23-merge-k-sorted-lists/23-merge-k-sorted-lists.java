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
        int n = lists.length;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        
        ListNode res = new ListNode(0);
        ListNode p = res;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = new ListNode(node.val);
            p = p.next;
            node = node.next;
            if (node != null) pq.add(node);
        }
        
        return res.next;
    }
}