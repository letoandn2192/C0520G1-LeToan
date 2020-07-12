package dsa_list.exercises.array_list;

import java.util.Arrays;

public class MyList {
    private int size;
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;

    public MyList(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        this.elements = new Object[capacity];
    }

    private void ensureCapacity(int minCapacity){
        this.elements = Arrays.copyOf(this.elements, minCapacity);
    }

    public void add(int index, Object element){
        if(this.size == this.elements.length){
            this.ensureCapacity(this.elements.length+1);
        }
        for (int i = this.elements.length-1; i > index; i--){
            this.elements[i] = this.elements[i-1];
        }
        this.elements[index] = element;
        this.size++;
    }

    public Object remove(int index){
        for(int i = index; i < this.elements.length-1; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.elements[this.elements.length-1] = null;
        this.size--;
        return this;
    }

    public int size(){
        return this.size;
    }

    public Object get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }else {
            return this.elements[index];
        }
    }

    public void clear(){
        for(int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
        this.size = 0;
    }

    public Object clone(){
        return Arrays.copyOf(this.elements,this.size);
    }

    public boolean contains(Object element){
        for (int i = 0; i < this.size(); i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

}
