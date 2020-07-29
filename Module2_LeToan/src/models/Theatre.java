package models;

import java.util.Deque;
import java.util.LinkedList;

public class Theatre {
    public final int CAPACITY = 10;
    private Deque<String> queue = new LinkedList<>();
    private int available = CAPACITY;

    public int getAvailable() {
        return available;
    }

    public void buyTicket(String name, int numberOfTicket){
        if(available > numberOfTicket){
            queue.add(name);
            System.out.println("Successful!!!");
            available -= numberOfTicket;
        } else if (available == numberOfTicket){
            queue.add(name);
            available = 0;
            System.out.println("List of customer: ");
            while (!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        } else {
            System.out.println("Sorry!!!. Just only have " + available + " tickets.");
        }
    }
}
