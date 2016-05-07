package graphAlgorithms;

import java.util.Iterator;
import java.util.Optional;

/**
 * Graph node that is composed of a name and edges.
 */
public class Node implements Iterable<Edge> {
    final String name;
    private final Edges edges;

    public Node(String name) {
        this.name = name;
        this.edges = new Edges();
    }

    public Iterator<Edge> iterator() {
        return edges.iterator();
    }

    public Edge addEdge(Node node) {
        Edge edge = new Edge(this, node);
        edges.add(Optional.of(edge));
        return edge;
    }

    public Nodes connectedTo() {
        Nodes nodes = new Nodes();
        for (Edge edge : edges) {
            nodes.add(this.equals(edge.node1) ? edge.node2 : edge.node1);
        }
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name.equals(node.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), name);
    }
}
