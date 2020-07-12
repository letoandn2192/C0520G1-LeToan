package dsa_stack_queue.practical.queue;

import dsa_list.exercises.linked_list.MyLinkedList;

public class MyLinkedListQueue {
    class Node{
        public int key;
        private Node next;

        public Node(int key){
            this.key = key;
        }

        public int getKey() {
            return this.key;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedListQueue(){
    }

    public void enqueue(int key){
        Node temp = new Node(key);
        if(this.tail == null){
            this.head = this.tail = temp;
        }else {
            this.tail.next = temp;
            this.tail = this.tail.next;
        }
    }

    public Node dequeue(){
        if(this.head == null){
            return null;
        }else {
            Node temp = this.head;
            this.head = temp.next;
            if (this.head == null)
                this.tail = null;
            return temp;
        }
    }
}
