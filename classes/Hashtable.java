package classes;

import java.util.ArrayList;
import java.util.List;

public class Hashtable<K, V> {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
    }

    int size = 16;
    Node<K, V>[] nodes = new Node[size];

    // Метод получения индекса пары по ключу 
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Добавление ключа и значения
    // Если ключ существует, то метод вернет текущее значение по ключу и перезапишет его на новое
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>();
        Node<K, V> currNode = nodes[index];
        newNode.key = key;
        newNode.value = value;

        while (currNode != null) {
            if (currNode.key == key) {
                V oldValue = currNode.value;
                currNode.value = value;
                return oldValue;
            }
            currNode = currNode.next;
        }

        newNode.next = nodes[index];
        nodes[index] = newNode;
        return null;
    }

    // Метод получения всех ключей
    public List<K> keys() {
        List<K> keys = new ArrayList<K>();
        for (Node<K, V> node : nodes) {
            while (node != null) {
                keys.add(node.key);
                node = node.next;
            }
        }
        return keys;
    }

    // Метод получения всех значений
    public List<V> values() {
        List<V> values = new ArrayList<V>();
        for (Node<K, V> node : nodes) {
            while (node != null) {
                values.add(node.value);
                node = node.next;
            }
        }
        return values;
    }

    // Метод получения значения по ключу
    public V item(K key) {
        for (Node<K, V> node : nodes) {
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    // Метод получения количества элементов таблицы
    public int size() {
        int size = 0;
        for (Node<K, V> node : nodes) {
            while (node != null) {
                size++;
                node = node.next;
            }
        }
        return size;
    }

    // Метод удаления пары по ключу
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];

        while (node != null) {
            if (node.key == key) {
                nodes[index] = node.next;
                return;
            }
            node = node.next;
        }
        return;
    }

    // Метод замены значения по ключу
    public void replace(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];

        while (node != null) {
            if (node.key == key) {
                nodes[index].value = value;
                return;
            }
            node = node.next;
        }
        return;
    }

    // Метод проверки существования ключа
    public boolean containsKey(K key) {
        for (Node<K, V> node : nodes) {
            while (node != null) {
                if (node.key == key) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    // Метод проверки существования значения
    public boolean containsValue(V value) {
        for (Node<K, V> node : nodes) {
            while (node != null) {
                if (node.value == value) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

}