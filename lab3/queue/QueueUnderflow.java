package queue;

public class QueueUnderflow extends RuntimeException {
    public QueueUnderflow() {
        super("The queue is empty!");
    }
}
