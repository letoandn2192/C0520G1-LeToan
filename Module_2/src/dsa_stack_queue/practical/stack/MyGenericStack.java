package dsa_stack_queue.practical.stack;

import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack(){
        stack = new LinkedList<T>();
    }

    public void push(T element){
        stack.addLast(element);
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Error!!!");
        }
        return this.stack.removeFirst();
    }

    public int size(){
        return this.stack.size();
    }

    public boolean isEmpty(){
        if(this.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
