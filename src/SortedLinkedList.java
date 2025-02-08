public class SortedLinkedList<T extends Comparable<T>> {

    // Node class to store list elements and reference to the next node
    private final class Node {
        T value;
        Node next;

        // Constructor to initialize the node with value and next reference
        Node(T val, Node n) {
            value = val;
            next = n;
        }

        // Constructor to initialize node with only value
        Node(T val) {
            this(val, null);
        }
    }

    private Node first; // List head (start)

    // Constructor to initialize the list as empty
    public SortedLinkedList() {
        first = null;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Method to get the element at a specific index
    public T get(int index) {
        Node current = first;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }

        return null; // Return null if index is out of bounds
    }

    // Method to get the size (number of elements) of the list
    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to add an element to the list in sorted order
    public void add(T element) {
        Node newNode = new Node(element);

        // Case 1: List is empty or element should be placed at the beginning
        if (first == null || element.compareTo(first.value) < 0) {
            newNode.next = first;
            first = newNode;
            return;
        }

        // Case 2: Find the proper place to insert the element
        Node current = first;
        while (current.next != null && element.compareTo(current.next.value) > 0) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to convert the list to a string representation
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node current = first;

        while (current != null) {
            str.append(current.value).append(",");
            current = current.next;
        }

        // Remove last comma and add closing bracket
        if (str.length() > 1) {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");

        return str.toString();
    }

    // Method to remove an element from the list
    public boolean remove(T element) {
        // Case 1: The list is empty
        if (first == null) {
            return false;
        }

        // Case 2: The element to be removed is the first element
        if (element.equals(first.value)) {
            first = first.next;
            return true;
        }

        // Case 3: Search for the element to remove
        Node current = first;
        while (current.next != null && !element.equals(current.next.value)) {
            current = current.next;
        }

        // Case 4: Element not found
        if (current.next == null) {
            return false;
        }

        // Remove the node
        current.next = current.next.next;
        return true;
    }
}
