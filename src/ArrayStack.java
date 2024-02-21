import java.util.Arrays;

public class ArrayStack <E> implements Stack<E>{
    private E data[];
    private int t=-1;
    public ArrayStack(int cap){

        data= (E[]) new Object[cap];
    }




    @Override
    public int size() {
        return (t+1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E element) {
        if (size()==data.length)throw new IllegalStateException("Stack Is full");
// ++ الزياة القبلية تعني زيد قبل التخزين
        data[++t]=element;

    }

    @Override
    public E pop() {

        if (isEmpty())return null;
        E deleted=data[t];
        data [t]=null;
        return deleted;
    }

    @Override
    public E top() {
        if (isEmpty())return null;
        return data[t];
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>*************<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q4.    Implement the clone( ) method for the ArrayStack class.
    @Override
    protected ArrayStack<E> clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
                ArrayStack<E> clone = (ArrayStack<E>) super.clone();
        clone.data = Arrays.copyOf(this.data,this.data.length);
        return clone();
    }
}
