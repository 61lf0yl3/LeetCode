/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    
public:
    Node* cloneGraph(Node* node) {
        if (node == NULL) {
            return NULL;
        }
        queue<Node*> q;
        q.push(node);
        m[node] = new Node(node->val);
        
        while (!q.empty()) {
            Node* currNode = q.front();
            q.pop();
            
            for (int i = 0; i < currNode->neighbors.size(); i++) {
                Node* neighbor = currNode->neighbors[i];
                if (m.find(neighbor) == m.end()) {
                    q.push(neighbor);
                    m[neighbor] = new Node(neighbor->val);
                }
                m[currNode]->neighbors.push_back(m[neighbor]);
            }
        }
        return m[node];
    }
    
private:
    unordered_map<Node*, Node*> m;
};