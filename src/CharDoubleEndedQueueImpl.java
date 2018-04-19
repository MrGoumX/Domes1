import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharDoubleEndedQueueImpl<T> implements CharDoubleEndedQueue<T> {

    private DoubleEndedNode<T> first, last;
    private int size;

    //Checks if double ended queue is empty
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    //Adding item at first position
    @Override
    public void addFirst(T item) {
        DoubleEndedNode<T> temp = new DoubleEndedNode<T>(item);
        if (isEmpty()) {
            first = last = temp;
        } else {
            temp.next = first;
            first.previous = temp;
            first = temp;
        }
        size++;
    }

    //Removing item from first position
    @Override
    public T removeFirst() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        T removed = first.getElement();
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return removed;
    }

    //Adding item at last position
    @Override
    public void addLast(T item) {
        DoubleEndedNode<T> temp = new DoubleEndedNode<T> (item);
        if (isEmpty()) {
            first = last = temp;
        } else {
            temp.previous = last;
            last.next = temp;
            last = temp;
        }
        size++;
    }

    //Removing item from last position
    @Override
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        T removed = last.getElement();
        if (first == last){
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return removed;
    }

    //Returns the first item of the double ended queue
    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.getElement();
    }

    //Returns the last item of the double ended queue
    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return last.getElement();
    }

    //Prints the double ended queue
    @Override
    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.printf("The Double Ended Queue is empty" + System.lineSeparator());
            return;
        }
        DoubleEndedNode<T> temp = first;
        while (temp != null) {
            System.out.printf("%s ", temp.getElement());
            temp = temp.getNext();
        }
        System.out.printf(System.lineSeparator());
    }

    //Returns the size of the double ended queue
    @Override
    public int size() {
        return size;
    }
}
