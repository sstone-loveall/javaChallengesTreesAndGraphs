package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

    Graph graph;
    
    public PathFinder(Graph graph) {
        this.graph = graph;
    }
    
    /***
     * Determine if a path exists between two nodes.
     * Use BFS to traverse the graph.
     * @param start: The node to start searching at
     * @param end: The goal destination node
     * @return true if a path is discovered from start to end nodes
     */
    public Boolean pathExists(Node start, Node end) {
        
        // check edge case that start and end are the same
        if (start == end) return true;
        
        // keep a queue of nodes that shall be visited
        Queue<Node> nodesToVisit = new LinkedList<Node>();
        
        // initialize starting node by adding it to the queue
        nodesToVisit.add(start);
        
        // while there are nodes to visit, check them out
        Node currentNode;
        while (!nodesToVisit.isEmpty()) {
            currentNode = nodesToVisit.poll(); // dequeue the first item
            if (currentNode != null) {
                // check out its neighbors
                for (Node neighbor : currentNode.getAdjacent()) {
                    // check state to avoid cycles
                    if (neighbor.getState() == NodeState.UNVISITED) {
                        // is the neighbor the desired end node?
                        if (neighbor == end) {
                            return true;
                        }
                        else {
                            // not yet found, so add to the queue
                            nodesToVisit.add(neighbor);
                        }
                    }
                }
                
                // the node has been checked and all its neighbors have been queued
                // mark it as visited to avoid repeating this work
                currentNode.setState(NodeState.VISITED);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // demo of graph
        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n0.setAdjacent(new Node[] { n1, n2 });
        n1.setAdjacent(new Node[] { n3 });
        n2.setAdjacent(new Node[] { n3 });
        n3.setAdjacent(new Node[] { n4 });
        
        Node[] graphNodes = new Node[] { n0, n1, n2, n3, n4 };
        
        PathFinder finder = new PathFinder(new Graph(graphNodes));
        System.out.println("Path from 0 to 4? Should be true. Found: " + finder.pathExists(n0, n4));
        System.out.println("Path from 2 to 4? Should be true. Found: " + finder.pathExists(n2, n4));
        System.out.println("Path from 1 to 3? Should be true. Found: " + finder.pathExists(n1, n3));
        System.out.println("Path from 1 to 1? Should be true. Found: " + finder.pathExists(n1, n1));
        System.out.println("Path from 2 to 1? Should be false. Found: " + finder.pathExists(n2, n1));
        System.out.println("Path from 4 to 3? Should be false. Found: " + finder.pathExists(n4, n3));
    }
}
