public class DoubleEndedNode<T> {
    private T element;
    protected DoubleEndedNode<T> next;
    protected DoubleEndedNode<T> previous;

    //Constructors
    DoubleEndedNode(T element) {
        this(element, null, null);
    }

    public DoubleEndedNode(T element, DoubleEndedNode<T> next, DoubleEndedNode<T> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    //Returns the element of the DoubleEndedNode
    T getElement() {
        return element;
    }

    //Returns the next DoubleEndedNode
    DoubleEndedNode<T> getNext() {
        return next;
    }

    //Returns the previous DoubleEndedNode
    DoubleEndedNode<T> getPrevious() {
        return previous;
    }
}
