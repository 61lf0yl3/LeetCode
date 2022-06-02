/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> m = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        } 
        Node clone = head;
        Node res = new Node(head.val);
        m.put(clone, res);
        while (clone != null) {
            res.next = getClone(clone.next);
            res.random = getClone(clone.random);
            
            res = res.next;
            clone = clone.next;
        }
        return m.get(head);
    }
    
    private Node getClone(Node node) {
        if (node == null) {
            return null;
        }
        if (!m.containsKey(node)) {
            m.put(node, new Node(node.val));
        }
        return m.get(node);
    }
}