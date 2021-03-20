import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E> {

    public E peek(){
        return super.get(this.size() - 1);
    }

    public void push(E o) {
        super.add(o);
    }

    public E pop() {
        int len = super.size();
        return super.remove(len - 1);
    }

    public int size() {
        return super.size();
    }
    public boolean isEmpty() {
        return super.size() == 0;
    }

    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}
