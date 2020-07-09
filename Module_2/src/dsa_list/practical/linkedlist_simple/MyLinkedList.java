package dsa_list.practical.linkedlist_simple;

public class MyLinkedList {
    class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    Node head;
    private int numNodes;

    public MyLinkedList(Object data){
        this.head = new Node(data);
    }

    public void add(int index, Object data){
        Node temp = this.head;
        Node holder;

        for(int i = 0; i < index && temp.next != null; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data){
        Node temp = this.head;
        this.head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index){
        Node temp = this.head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        return temp;
    }

    public void printList(){
        Node temp = this.head;
        while (temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
