import java.io.PrintStream;
import java.util.NoSuchElementException;

public class CharQueueWithMinImpl<T extends Comparable<T>> implements CharQueueWithMin<T>{
    private CharDoubleEndedQueueImpl<T> doubleList = new CharDoubleEndedQueueImpl<T>();
    private CharQueueImpl<T> fifoList = new CharQueueImpl<T>();
    private DefaultComparator<T> cmp = new DefaultComparator<T>();

    //Checks if queue is empty
    @Override
    public boolean isEmpty() {
        return fifoList.isEmpty();
    }

    //Adds item in the back of the queue and adds item in the double ended queue with criteria
    @Override
    public void put(T item) {
        fifoList.put(item);
        doubleList.addFirst(item);
        if (!isEmpty()) {
          while (cmp.compare(doubleList.getFirst(), item) > 0) doubleList.removeFirst();
        }
    }

    //Removes item from the front of the queue and removes items from the double ended queue with criteria
    @Override
    public T get() throws NoSuchElementException {
        T removed = fifoList.get();
        if (cmp.compare(removed, doubleList.getLast()) == 0) doubleList.removeLast();
        return removed;
    }

    //Returns the first item of the queue without removing it
    @Override
    public T peek() throws NoSuchElementException {
        return fifoList.peek();
    }

    //Returns the minimum item from the queue using the double ended queue
    @Override
    public T min() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return doubleList.getLast();
    }

    //Prints the queue
    @Override
    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.printf("The QueueWithMin is empty");
            return;
        }
        fifoList.printQueue(stream);
    }

    //Returns the size of the queue
    @Override
    public int size() {
        return fifoList.size();
    }
}
