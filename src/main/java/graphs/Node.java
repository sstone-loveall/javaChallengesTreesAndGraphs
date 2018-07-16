package graphs;

/***
 * Represent a Node. It has a state and a list of adjacent nodes.
 *
 */
public class Node {
    
    NodeState state;
    Node[] adjacentNodes;
    
    public Node() {
        state = NodeState.UNVISITED;
        this.adjacentNodes = new Node[0]; // initialize with no adjacent nodes
    }
    
    public Node(Node[] adjacentNodes) {
        state = NodeState.UNVISITED; // initialize the node as unvisited
        this.adjacentNodes = adjacentNodes;
    }
    
    public Node[] getAdjacent() {
        return adjacentNodes;
    }
    
    public void setAdjacent(Node[] adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
    
    public NodeState getState() {
        return state;
    }
    
    public void setState(NodeState state) {
        this.state = state;
    }
}
