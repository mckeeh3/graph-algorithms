package graphAlgorithms;

/**
 * A undirected or simple graph implementation.
 *
 * @see
 * <a href="https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)#Simple_graph">Graph (discrete mathematics)</a>
 */
public class UndirectedGraph {
    final Nodes nodes;
    final Edges edges;

    public UndirectedGraph(Nodes nodes, Edges edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
