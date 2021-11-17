package main;

import tasks.ReadTask;
import tasks.WriteTask;

import java.util.concurrent.*;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        int countOfThreads = Integer.parseInt(args[0]);

        ExecutorService executorWriter = Executors.newFixedThreadPool(countOfThreads, new ThreadFactory() {
            private int number = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Writer №" + ++number);
            }
        });

        ExecutorService executorReader = Executors.newFixedThreadPool(countOfThreads, new ThreadFactory() {
            private int number = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Reader №" + ++number);
            }
        });

        BlockingQueue<String> queueOfMessage = new LinkedBlockingQueue<>();

        WriteTask writeTask = new WriteTask(queueOfMessage);
        ReadTask readTask = new ReadTask(queueOfMessage);

        for (int i=0; i < countOfThreads; i++)
        {
            executorWriter.submit(writeTask);
            executorReader.submit(readTask);
        }

        executorWriter.shutdown();
        executorReader.shutdown();
    }
}
