package dsa_stack_queue.exercises.circle_linkedlist;

public class Solution {
    public void enQueue(Queue queue, int data) {
        Node newNode = new Node(data);
        if (queue.getFront() == null) {
            queue.setFront(newNode);
        } else {
            queue.getRear().setLink(newNode);
        }
        queue.setRear(newNode);
        queue.getRear().setLink(queue.getFront());
    }

    public int deQueue(Queue queue) {
        int data;
        if (queue.getFront() == null) {
            System.out.println("Queue is empty");
            return 0;
        } else if (queue.getFront() == queue.getRear()) {
            data = queue.getFront().getData();
            queue.setRear(null);
            queue.setFront(null);
            return data;
        } else {
            data = queue.getFront().getData();
            queue.setFront(queue.getFront().getLink());
            queue.getRear().setLink(queue.getFront());
            return data;
        }
    }

    public void displayQueue(Queue queue) {
        Node temp = queue.getFront();
        if (queue.getFront() == null) {
            System.out.println("Queue is empty!!!");
        } else {
            while (temp.getLink() != queue.getFront()) {
                System.out.print(temp.getData() + "\t");
                temp = temp.getLink();
            }
            System.out.print(temp.getData());
        }
    }
}
