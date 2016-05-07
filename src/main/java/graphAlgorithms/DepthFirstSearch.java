package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * A depth first search implementation.
 */
public class DepthFirstSearch {
    public List<Node> search(UndirectedGraph graph) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node first = graph.nodes.first().get();

        visit(first, stack, result);

        while (!stack.isEmpty()) {
            Node current = stack.peek();
            Optional<Node> next = firstUnvisited(current, result);
            if (next.isPresent()) {
                visit(next.get(), stack, result);
            } else {
                stack.pop();
            }
        }

        return result;
    }

    private void visit(Node node, Stack<Node> stack, List<Node> visited) {
        stack.add(node);
        visited.add(node);
    }

    private Optional<Node> firstUnvisited(Node node, List<Node> visitedNodes) {
        return node.connectedTo().stream().filter(n -> !visited(n, visitedNodes)).findFirst();
    }

    private boolean visited(Node node, List<Node> visitedNodes) {
        return visitedNodes.contains(node);
    }
}
