package classes;
// Очередь из чисел
public class Queue {
    // Объект узла (нода)
    public class Node {
        int value;
        Node next;
        Node previous;
    }

    Node head;
    Node tail;
    Integer count = 0;

    // Геттер count
    public int getCount() {
        return this.count;
    }

    // Извлечение элемента из очереди
    public Integer peek() {
        if (count == 0) return null;
    
        int result = tail.value;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
    
        if (count > 0) count--;
        return result;
    }

    // Добавление элемента в очередь
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
        count++;
    }
}
