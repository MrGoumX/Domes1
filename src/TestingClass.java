public class TestingClass {
    public static void main(String[] args){
        TestDoubleEndedQueue();
        TestQueue();
        TestQueueWithMin();
    }

    private static void TestDoubleEndedQueue(){
        System.out.println("Now Testing the Double Ended Queue with Characters");
        CharDoubleEndedQueueImpl<Character> deq = new CharDoubleEndedQueueImpl<Character>();
        deq.addFirst('E');
        deq.addFirst('T');
        deq.addLast('S');
        deq.addLast('T');
        deq.printQueue(System.out);
        deq.removeFirst();
        deq.removeLast();
        deq.printQueue(System.out);
        deq.removeLast();
        deq.removeLast();
        deq.printQueue(System.out);
    }

    private static void TestQueue(){
        System.out.println("Now Testing the FIFO Queue with Characters");
        CharQueueImpl<Character> q = new CharQueueImpl<Character>();
        q.put('T');
        q.put('E');
        q.put('S');
        q.put('T');
        q.printQueue(System.out);
        q.get();
        q.printQueue(System.out);
        System.out.println(q.peek());
        q.get();
        q.get();
        q.get();
        q.printQueue(System.out);
    }

    private static void TestQueueWithMin(){
        System.out.println("Now Testing the FIFO Queue with min implementation using Double Ended Queue with Characters");
        CharQueueWithMinImpl<Character> qm = new CharQueueWithMinImpl<Character>();
        qm.put('T');
        qm.put('E');
        qm.put('S');
        qm.put('T');
        System.out.println(qm.min());
        qm.printQueue(System.out);
        qm.get();
        System.out.println(qm.min());
        qm.printQueue(System.out);
        qm.get();
        System.out.println(qm.min());
        qm.printQueue(System.out);
        qm.get();
        System.out.println(qm.min());
        qm.printQueue(System.out);
        System.out.println(qm.peek());
        qm.get();
        qm.printQueue(System.out);
        System.out.println(qm.min());
    }
}
