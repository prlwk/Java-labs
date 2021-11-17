package supervisor;

import abstractProgram.AbstractProgram;

public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;

    public Supervisor(AbstractProgram abstractProgram) {
        this.abstractProgram = abstractProgram;
    }

    @Override
    public void run() {
        while (abstractProgram.getState() != AbstractProgram.StateOfThread.FATAL_ERROR) {
            synchronized (abstractProgram.getLock()) {
                if (abstractProgram.isReadyToChange()) {
                    try {
                        abstractProgram.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (abstractProgram.getState() == AbstractProgram.StateOfThread.UNKNOWN
                        || abstractProgram.getState() == AbstractProgram.StateOfThread.STOPPING) {
                    startProgram();
                }
                abstractProgram.setReadyToChange(true);
                abstractProgram.getLock().notify();
            }
        }
        stopProgram();
    }

    private void stopProgram() {
        System.out.println("Stop program");
        Thread.currentThread().interrupt();
    }

    private void startProgram() {
        System.out.println("Restarting program");
        abstractProgram.setState(AbstractProgram.StateOfThread.RUNNING);
    }
}
