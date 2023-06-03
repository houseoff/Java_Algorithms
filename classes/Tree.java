package classes;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    
    Node root;

    public class Node {
        int value;
        List<Node> children;
    }

    // Интерфейс для метода обхода в глубину
    public boolean exist(int value) {
        if (root != null) {
            Node node = searchInDepth(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    // Обход в глубину
    private Node searchInDepth(Node node, int value) {
        if (node.value == value) {
            return node;
        }
        else {
            for (Node child : node.children) {
                Node result = searchInDepth(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // Обход в ширину
    private Node searchInWidth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node: line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

}
