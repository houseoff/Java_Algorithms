// Двусвязный список с реализацией методов очереди
public class lecture3_2 {
    
    // Объект узла (нода)
    public class Node {
        int value;
        Node next;
        Node previous;
    }

    Node head;
    Node tail;

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

    }

    // Добавление элемента в список
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

    }

    // Удаление элемента из списка
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
    }


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

    // Добавление элемента в очередь
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    // Извлечение элемента из очереди
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

}
