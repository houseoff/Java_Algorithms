import classes.DoublyLinkedList;
import java.util.Random;

public class homework3 {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        fillList(list, 10);
        System.out.print("Исходный список: ");
        printList(list);

        System.out.print("Развернутый список: ");
        list.reverse();
        printList(list);
    }

    // Заполнение списка псевдослучайными числами
    public static void fillList(DoublyLinkedList list, int elCount) {
        Random random = new Random();
        for (int i = 0; i < elCount; i++) {
            list.add(random.nextInt(100));
        }
    }

    // Печать списка
    public static void printList(DoublyLinkedList list) {
        DoublyLinkedList.Node node = list.getHead();
        System.out.print("[");
        for (int i = 0; i < list.getCount(); i++) {
            if (i == list.getCount() - 1) {
                System.out.print(node.getValue());
            }
            else {
                System.out.print(node.getValue() + ", ");
                node = node.getNext();
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
