package dsa_stack_queue.practical.queue;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue().key);
        System.out.println(queue.dequeue().key);

    }
}
