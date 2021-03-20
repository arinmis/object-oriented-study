/**
 *  @author Mustafa Arınmış
 *  @since 30.06.2020
 *
 *  Introduction to Java Programming - 10.10
 *(The Queue class) Section 10.6 gives a class for Stack . Design a class named
 * Queue for storing integers. Like a stack, a queue holds elements. In a stack, the
 * elements are retrieved in a last-in first-out fashion. In a queue, the elements are
 * retrieved in a first-in first-out fashion. The class contains:
 * 
 * An int[] data field named elements that stores the int values in the
 * queue.
 * A data field named size that stores the number of elements in the queue.
 * A constructor that creates a Queue object with default capacity 8 .
 * The method enqueue(int v) that adds v into the queue.Programming Exercises 403
 * The method dequeue() that removes and returns the element from the
 * queue.
 * The method empty() that returns true if the queue is empty.
 * The method getSize() that returns the size of the queue.
 * */



import java.util.ArrayList;

public class Workout {
    public static void main(String[] args) {
        Queue queue = new Queue();

        for(int i=1; i<21; i++)
            queue.enqueue(i);

        //Size is changing dynamically
        int time = queue.getSize();
        for(int i=0; i<time; i++)
            System.out.println(queue.dequeue());
    }
}

class Queue {
    private int[] elements;
    private int size;
    private int capacity = 8;

    public Queue() {
        elements = new int[capacity];
    }

    public void enqueue(int v) {
        elements[size++] = v;

        if(size % capacity == 0) {
            capacity *= 2;
            int[] tempArr = new int[capacity];
            for(int i=0; i<size; i++) {
                tempArr[i] = elements[i];
            }
            elements = tempArr;
        }
    }

    public int dequeue() {
        int[] tempArr = new int[size];
        int temp = elements[0];

        for(int i=1; i<size; i++) {
            tempArr[i-1] = elements[i];
        }
        size--;
        elements = tempArr;
        return temp;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}

