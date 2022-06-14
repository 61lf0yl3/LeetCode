/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node prev = head;
        Node curr = head.next;
        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                prev.next = node;
                node.next = curr;
                return head;
            } else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    prev.next = node;
                    node.next = curr;
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
        } while ( prev != head);
        
        prev.next = node;
        node.next = curr;
        return head;
    }
}