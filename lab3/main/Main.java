package main;

import animal.*;
import queue.Queue;
import queue.QueueOverflow;
import queue.QueueUnderflow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Queue<Chordates> animals = new Queue<>(13);
        fillQueue(animals);
        Queue<? extends Feline> feline = produce(animals);
        List<Queue<Feline>> queues = consume(feline);
        System.out.println("Ancestors of Tiger:");
        Queue<? super Tiger> ancestorsTiger = queues.get(0);
        printInfo(ancestorsTiger);
        System.out.println("Ancestors of Forest Cat:");
        Queue<? super ForestCat> ancestorsForestCat = queues.get(1);
        printInfo(ancestorsForestCat);
    }

    public static Queue<Feline> produce(Queue<? extends Chordates> chordates) {
        Queue<Feline> newQueue = null;
        if (chordates != null) {
            newQueue = new Queue<>(chordates.getMaxSize());
            while (!chordates.isEmpty()) {
                Chordates temp = chordates.get();
                if (temp instanceof Feline) {
                    newQueue.add((Feline) temp);
                }
            }
        }
        return newQueue;
    }

    public static List<Queue<Feline>> consume(Queue<? extends Chordates> animals) {
        Queue<Feline> ancestorsTiger = null;
        Queue<Feline> ancestorsForestCat = null;
        if (animals != null) {
            ancestorsTiger = new Queue<>(animals.getMaxSize());
            ancestorsForestCat = new Queue<>(animals.getMaxSize());
            while (!animals.isEmpty()) {
                Chordates temp = animals.get();
                if (!(temp instanceof Lion) && !(temp instanceof Cats)) {
                    ancestorsTiger.add((Feline) temp);
                }
                if (!(temp instanceof DomesticCat) && !(temp instanceof Panther)) {
                    ancestorsForestCat.add((Feline) temp);
                }
            }
        }
        List<Queue<Feline>> queues = new ArrayList<>();
        queues.add(ancestorsTiger);
        queues.add(ancestorsForestCat);
        return queues;
    }

    public static void fillQueue(Queue<Chordates> animals) throws QueueOverflow {
        if (animals != null) {
            animals.add(new Tiger());
            animals.add(new Dog());
            animals.add(new Lion());
            animals.add(new Canines());
            animals.add(new Cats());
            animals.add(new DomesticCat());
            animals.add(new Feline());
            animals.add(new ForestCat());
            animals.add(new Mammals());
            animals.add(new Panther());
            animals.add(new Predatory());
            animals.add(new Wolves());
            animals.add(new Chordates());
        }
    }

    public static void printInfo(Queue<?> queue) throws QueueUnderflow {
        if (queue != null) {
            while (!queue.isEmpty()) {
                System.out.println(queue.get());
            }
        }
    }
}
