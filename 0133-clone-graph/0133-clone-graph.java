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
    HashMap<Node,Node> mpp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(mpp.containsKey(node)){
            return mpp.get(node);
        }
        Node newnode = new Node(node.val);
        mpp.put(node,newnode);

        for(Node it: node.neighbors){
            newnode.neighbors.add(cloneGraph(it));
        }
        return newnode;
    }
}