package dsa_stack_queue.exercises.circle_linkedlist;

public class Queue {
    private Node front;
    private Node rear;

    public Queue(Node front, Node rear) {
        this.front = front;
        this.rear = rear;
    }

    public Queue() {
    }

    public Node getFront() {
        return this.front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return this.rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }
}
