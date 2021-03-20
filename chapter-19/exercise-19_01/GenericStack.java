/**
 *  Programming Exercise 19.01
 *
 *  (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to imple-
 *  ment it using an array rather than an ArrayList . You should check the array size
 *  before adding a new element to the stack. If the array is full, create a new array that
 *  doubles the current array size and copy the elements from the current array to the
 *  new array.
 *
 *  @author Mustafa Arinmis
 *  @since 30.12.2020
 * */


import java.util.Arrays;

public class GenericStack<E> {
    public static int INITIAL = 100;
    private int size;
    private E[] list;

    public GenericStack(int capacity) {
        this.list = (E[])new Object[capacity];
        this.size = 0;
    }

    public GenericStack() {
        this(INITIAL); // create default capacity array
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        return list[size - 1];
    }

    public void push(E o) {
        if(size == list.length) {
            E[] extendedList = (E[])new Object[list.length + INITIAL]; //create new list that more has capacity list
            transferValues(extendedList, list); //put old values to the new array
            list = extendedList;
        }
        list[size++] = o;
    }

    public E pop() {
        E o = list[size - 1];
        size--; // there is no actually removing operation, but we can't access this element now
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    /* put old list's element to the new one */
    private void transferValues(E[] newest, E[] old) {
        for(int i=0; i<old.length; i++)
            newest[i] = old[i];
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(list);
    }
}
