package dsa_list.practical.list_simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList {
    private int size;
    private int DEFAULT_CAPACITY = 8;
    Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void addLast(Object element){
        if(size == elements.length){
            this.ensureCapa();
        }
        elements[size++] = element;
    }

    public void addFirst(Object element){
        if(size == elements.length){
            this.ensureCapa();
        }
        for(int i = elements.length-1; i > 0; i--){
            elements[i] = elements[i-1];
        }
        elements[0] = element;
        size++;
    }

    public Object get(int index){
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return elements[index];
    }

    public int getSize() {
        return size;
    }
}
