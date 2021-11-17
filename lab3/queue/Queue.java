package queue;

public class Queue<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> list;
    private final int maxSize;
    private int rear;

    public Queue(final int maxSize) {
        if (maxSize < 1) {
            throw new NegativeArraySizeException();
        }
        this.list = null;
        this.maxSize = maxSize;
        this.rear = -1;
    }

    public void add(final T element) {
        if (rear == maxSize - 1) {
            throw new QueueOverflow();
        }
        if (list == null) {
            this.list = new Node<>(element);
        } else {
            Node<T> tmp = list;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(element);
        }
        rear++;
    }

    public T get() {
        if (this.isEmpty()) {
            throw new QueueUnderflow();
        }
        Node<T> tmp = list;
        list = list.next;
        return tmp.value;
    }

    public boolean isEmpty() {
        return list == null;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
