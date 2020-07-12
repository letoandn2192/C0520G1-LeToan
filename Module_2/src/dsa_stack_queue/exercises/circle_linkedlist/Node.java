package dsa_stack_queue.exercises.circle_linkedlist;

public class Node {
    private int data;
    private Node link;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLink() {
        return this.link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
