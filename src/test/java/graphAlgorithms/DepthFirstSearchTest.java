package graphAlgorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests {@link DepthFirstSearch}.
 */
public class DepthFirstSearchTest {
    @Test
    public void searchWorks() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        Nodes nodes = new Nodes("A", "B", "C", "D", "E", "F", "G", "H");
        Edges edges = new Edges();

        edges.add(nodes.addEdge("A", "B"));
        edges.add(nodes.addEdge("A", "D"));
        edges.add(nodes.addEdge("A", "G"));

        edges.add(nodes.addEdge("B", "A"));
        edges.add(nodes.addEdge("B", "E"));
        edges.add(nodes.addEdge("B", "F"));

        edges.add(nodes.addEdge("C", "F"));
        edges.add(nodes.addEdge("C", "H"));

        edges.add(nodes.addEdge("D", "A"));
        edges.add(nodes.addEdge("D", "F"));

        edges.add(nodes.addEdge("E", "B"));
        edges.add(nodes.addEdge("E", "G"));

        edges.add(nodes.addEdge("F", "B"));
        edges.add(nodes.addEdge("F", "C"));
        edges.add(nodes.addEdge("F", "D"));

        edges.add(nodes.addEdge("G", "A"));
        edges.add(nodes.addEdge("G", "E"));

        edges.add(nodes.addEdge("H", "C"));

        List<Node> result = depthFirstSearch.search(new UndirectedGraph(nodes, edges));
        assertNotNull(result);
    }
}
