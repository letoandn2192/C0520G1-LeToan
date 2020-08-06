package models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Theatre {
    public static final int CAPACITY = 10;
    private static Deque<ArrayList> queue = new LinkedList<>();
    private static int available = CAPACITY;

    public int getAvailable() {
        return available;
    }

    public void buyTicket(String name, int numberOfTicket){
        ArrayList list = new ArrayList();
        if(available > numberOfTicket){
            list.add(name);
            list.add(numberOfTicket);
            queue.add(list);
            System.out.println("Successful!!!");
            available -= numberOfTicket;
        } else if (available == numberOfTicket){
            list.add(name);
            list.add(numberOfTicket);
            queue.add(list);
            available = 0;
        } else {
            System.out.println("Sorry!!!. Just only have " + available + " tickets.");
        }

        if (available == 0) {
            System.out.println("List of customer: ");
            System.out.printf("%-15s%s", "Name", "Number of Ticket");
            while (!queue.isEmpty()){
                ArrayList temp = queue.poll();
                System.out.printf("%-15s%s", temp.get(0), temp.get(1));
                System.out.println();
            }
        }
    }
}
