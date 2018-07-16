package graphs;

/***
 * Represent a directed graph of nodes via adjacency matrix.
 *
 */
public class Graph {
    Node[] nodes;
    
    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }
    
    public Node[] getNodes() {
        return nodes;
    }
}
