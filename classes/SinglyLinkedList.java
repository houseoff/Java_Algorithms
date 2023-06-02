package classes;
// Односвязный список с реализацией методов стека
public class SinglyLinkedList {

    // Объект узла (нода)
    public class Node {
        int value;
        Node next;
    }

    // Нода Head содержит ссылку на значение текущего элемента и ссылку на ноду следующего элемента
    Node head;
    int count;

    // Геттер count
    public int getCount() {
        return this.count;
    }

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

    // Интерфейс для разворота
    public void reverse() {
        if (head != null && head.next != null) {
            reverse(head.next, head);
        }
    }

    // Разворот
    private void reverse(Node currNode, Node previousNode) {
        if (currNode.next == null) {
            head = currNode;
        } else {
            reverse(currNode.next, currNode);
        }
        currNode.next = previousNode;
        previousNode.next = null;
    }

    // Добавление элемента в начало
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    // Получение элемента с начала списка
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }
}
