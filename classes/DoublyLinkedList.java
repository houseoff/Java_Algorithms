package classes;
// Двусвязный список
public class DoublyLinkedList {
    
    // Объект узла (нода)
    public class Node {
        int value;
        Node next;
        Node previous;

        // Геттер next
        public Node getNext() {
            return this.next;
        }

        // Геттер previous
        public Node getPrevious() {
            return this.previous;
        }

        // Геттер next
        public int getValue() {
            return this.value;
        }
    }

    Node head;
    Node tail;
    Integer count = 0;

    // Геттер count
    public int getCount() {
        return this.count;
    }

    // Геттер head
    public Node getHead() {
        return head;
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

    // Добавление элемента в конец списка. Сложность = O(1)
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }

        count++;
    }

    // Добавление элемента в список. Сложность = O(1).
    // При этом поиск ноды занимает O(n)
    public void add(int value, Node node) {
        Node next = node.next;
        Node newnode = new Node();
        newnode.value = value;
        node.next = newnode;
        newnode.previous = node;
        if (next == null) {
            tail = newnode;
        } else {
            next.previous = newnode;
            newnode.next = next;
        }

        count++;
    }

    // Удаление элемента из списка. Сложность = O(1).
    // При этом поиск ноды занимает O(n)
    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;

        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }

        if (count > 0) count--;
    }

    // Разворот списка
    public void reverse() {
        Node currNode = head;
        while (currNode != null) {
            Node next = currNode.next;
            Node previous = currNode.previous;

            currNode.next = previous;
            currNode.previous = next;

            if (previous == null) {
                tail = currNode;
            }

            if (next == null) {
                head = currNode;
            }

            currNode = next;
        }
    }
}
