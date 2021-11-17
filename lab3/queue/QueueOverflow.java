package queue;

public class QueueOverflow extends RuntimeException {
    public QueueOverflow() {
        super("The queue is full!");
    }
}
