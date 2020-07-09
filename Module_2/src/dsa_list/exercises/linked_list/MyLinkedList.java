package dsa_list.exercises.linked_list;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList() {
    }

    public void addFirst(Object data) {
        Node temp = this.head;
        this.head = new Node(data);
        this.head.next = temp;
        this.numNodes++;
    }

    public void addLast(Object data) {
        Node temp = this.head;
        for (int i = 0; i < this.numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        this.numNodes++;
    }

    public Object remove(int index) {
        Node temp = this.head;
        Node current;
        if (index < 0 || index >= this.numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        } else if (index == 0) {
            current = this.head;
            this.head = this.head.next;
            numNodes--;
            return current.data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            current = temp.next;
            temp.next = current.next;
            numNodes--;
            return current.data;
        }
    }

    public int size() {
        return this.numNodes;
    }

    public Object get(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Object getFirst() {
        return this.head.data;
    }

    public Object getLast() {
        Node temp = this.head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void clear() {
        this.head = null;
        this.numNodes = 0;
    }


}
