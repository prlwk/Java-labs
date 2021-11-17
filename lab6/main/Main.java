package main;

import abstractProgram.AbstractProgram;
import supervisor.Supervisor;

public class Main {
    public static void main(String[] args) {
        AbstractProgram abstractProgram = new AbstractProgram(2000);
        Supervisor supervisor = new Supervisor(abstractProgram);
        new Thread(abstractProgram).start();
        new Thread(supervisor).start();
    }
}
