package classes;

public class Stack {
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

    // Просмотр первого элемента стека
    public Integer peek() {
        return head.value;
    }
    
    // Добавление элемента в начало стека
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }
    
    // Получение элемента из стека (из начала)
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

}
