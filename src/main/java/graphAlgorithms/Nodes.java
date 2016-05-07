package graphAlgorithms;

import java.util.*;
import java.util.stream.Stream;

/**
 * An ordered collection of {@link Node}s.
 */
public class Nodes implements Iterable<Node> {
    private final Map<String, Node> nodes = new HashMap<>();

    public Nodes(String... names) {
        for (String name : names) {
            nodes.put(name, new Node(name));
        }
    }

    public Iterator<Node> iterator() {
        return nodes.values().iterator();
    }

    public void add(Node node) {
        nodes.put(node.name, node);
    }

    public Optional<Node> get(String name) {
        return Optional.ofNullable(nodes.get(name));
    }

    public boolean contains(Node node) {
        return contains(node.name);
    }

    public boolean contains(String name) {
        return nodes.containsKey(name);
    }

    public Optional<Node> first() {
        return nodes.values().stream().findFirst();
    }

    public Stream<Node> stream() {
        return nodes.values().stream();
    }

    public Optional<Edge> addEdge(String name1, String name2) {
        Node node1 = nodes.get(name1);
        Node node2 = nodes.get(name2);
        if (node1 != null && node2 != null) {
            node1.addEdge(node2);
            return Optional.of(node2.addEdge(node1));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), nodes);
    }
}
