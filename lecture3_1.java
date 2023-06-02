package Algorithms;

// Односвязный список с реализацией методов стека
public class lecture3_1 {

    // Объект узла (нода)
    public class Node {
        int value;
        Node next;
    }

    // Нода Head содержит ссылку на значение текущего элемента и ссылку на ноду следующего элемента
    Node head;

    // Поиск элемемента в списке. Сложность = O(n)
    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    private void reverse(Node currNode, Node previousNode) {
        if (currNode.next == null) {
            head = currNode;
        } else {
            reverse(currNode.next, currNode);
        }
        currNode.next = previousNode;
        previousNode.next = null;
    }

    public void reverse() {
        if (head != null && head.next != null) {
            reverse(head.next, head);
        }
    }

    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }
}
