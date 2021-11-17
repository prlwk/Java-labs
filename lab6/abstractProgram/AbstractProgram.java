package abstractProgram;

import java.util.Random;

public class AbstractProgram implements Runnable {

    public enum StateOfThread {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }

    private StateOfThread state;
    private final int interval;
    private boolean readyToChange;
    private final Object lock;

    Runnable stateChanger = new Runnable() {
        @Override
        public void run() {
            Random random = new Random();
            while (getState() != StateOfThread.FATAL_ERROR) {
                synchronized (lock) {
                    if (!readyToChange) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    setState(StateOfThread.class.getEnumConstants()[random.nextInt(StateOfThread.class.getEnumConstants().length)]);
                    try {
                        Thread.sleep(interval);
                        readyToChange = false;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public AbstractProgram(int interval) {
        this.interval = interval;
        this.state = StateOfThread.RUNNING;
        this.readyToChange = false;
        this.lock = new Object();
    }

    public Object getLock() {
        return lock;
    }

    public boolean isReadyToChange() {
        return readyToChange;
    }

    public void setReadyToChange(boolean readyToChange) {
        this.readyToChange = readyToChange;
    }

    public StateOfThread getState() {
        return this.state;
    }

    public synchronized void setState(StateOfThread state) {
        this.state = state;
        System.out.println("State is " + state);
    }


    @Override
    public void run() {
        Thread stateChangerThread = new Thread(stateChanger);
        stateChangerThread.setDaemon(true);
        System.out.println("Start program");
        System.out.println("State is " + state);
        stateChangerThread.start();
    }
}
