package tasks;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WriteTask implements Runnable {
    BlockingQueue queue;
    Lock lock = new ReentrantLock();
    public <T> WriteTask(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            queue.put("Hi, I am  " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
