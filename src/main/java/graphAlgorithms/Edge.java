package graphAlgorithms;

/**
 * A graph edge that connect two {@link Node}s.
 */
public class Edge {
    final Node node1;
    final Node node2;

    public Edge(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return node1.equals(edge.node1) && node2.equals(edge.node2)
                || node1.equals(edge.node2) && node2.equals(edge.node1);
    }

    @Override
    public int hashCode() {
        int result = node1.hashCode();
        result = 31 * result + node2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s]", getClass().getSimpleName(), node1, node2);
    }
}
