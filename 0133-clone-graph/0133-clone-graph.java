/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        q.add(node);
        
        while (!q.isEmpty()) {
            Node currNode = q.poll();
                
            for (Node neighbor : currNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(currNode).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
        
        
        
        
//         Map<Node, Node> m = new HashMap<>();        
//         Node p = node;
//         while (p != null) {
//             m.put(p, new Node(p.val, new ArrayList()));
//             p = p.next;
//         }
//         p = node;
//         while (p != null) {
//             Node cuurNode = m.get(p); 
//             for (Node temp : p.neighbors) {
//                 cuurNode.neighbors.add(m.get(temp));
//             }
//         }
//         return m.get(node);
        
     }
}