package dsa_stack_queue.exercises.circle_linkedlist;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Solution solution = new Solution();
        solution.enQueue(queue,1);
        solution.enQueue(queue,2);
        solution.enQueue(queue,3);
        solution.enQueue(queue,4);
        solution.enQueue(queue,5);
        solution.displayQueue(queue);
    }
}
