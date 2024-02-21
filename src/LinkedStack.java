public class LinkedStack <E> implements Stack<E>{
    private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list
    public LinkedStack( ) { }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E top() {
        return list.first();
    }

//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**********<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // Q1.   Implement a method with signature transfer(S, T) that transfers all elements
    // from stack S onto stack T, so that the element that starts at the top of S is the first to be inserted onto T,
    // and the element at the bottom of S ends up at the top of T.

    public static void transfer(Stack<Integer> source, Stack<Integer> destination) {
        while (!source.isEmpty()) {
            destination.push(source.pop());
        }
    }
//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**********<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // Q2.  Give a recursive method for removing all the elements from a stack.

    public static void popAll(Stack<Integer> S) {
        if (!S.isEmpty()) {
            S.pop();
            popAll(S);
        }
    }






}
