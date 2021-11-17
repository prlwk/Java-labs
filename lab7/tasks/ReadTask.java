package tasks;

import java.util.concurrent.BlockingQueue;

public class ReadTask implements Runnable {
    BlockingQueue queue;

    public <T> ReadTask(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " reads: " + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
