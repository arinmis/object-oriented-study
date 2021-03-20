import java.util.ArrayList;

public class MyStack implements Cloneable{
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    public void setList(ArrayList<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        //clone primitives and references
        MyStack cloneStack = (MyStack) super.clone();

        //1 level deep copy
        ArrayList<Object> cloneList = new ArrayList<>(this.list);
        cloneStack.setList(cloneList);

        return cloneStack;

        /*
          since the object class has a protected clone method,
          objects, which inside the array list, cannot be cloned.
          So this method just deep clone array list not it's elements.
        */

    }
}
