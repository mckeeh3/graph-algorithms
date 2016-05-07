package graphAlgorithms;

import java.util.*;

/**
 * An ordered collection of edges.
 */
public class Edges implements Iterable<Edge> {
    private final Map<String, Edge> edges = new TreeMap<>();

    public Iterator<Edge> iterator() {
        return edges.values().iterator();
    }

    public Edges add(Optional<Edge> edge) {
        edge.ifPresent(e -> edges.put(key(e), e));
        return this;
    }

    private String key(Edge edge) {
        if (edge.node1.name.compareTo(edge.node2.name) < 0) {
            return edge.node1.name + edge.node2.name;
        } else {
            return edge.node2.name + edge.node1.name;
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), edges);
    }
}
