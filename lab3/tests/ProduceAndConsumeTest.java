package tests;

import animal.*;
import org.junit.jupiter.api.Test;
import queue.Queue;
import main.Main;
import queue.QueueOverflow;
import queue.QueueUnderflow;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProduceAndConsumeTest {
    private static Queue<Chordates> animals1 = null;
    private static Queue<Chordates> animals2 = null;

    private static void setUp(Queue<Chordates> animals) {
        Main.fillQueue(animals);
    }

    @Test
    void produce() {
        animals1 = new Queue<>(13);
        setUp(animals1);
        Queue<? extends Feline> felineQueue = Main.produce(animals1);
        while (!felineQueue.isEmpty()) {
            assertTrue(felineQueue.get() instanceof Feline);
        }
    }

    @Test
    void consume() {
        animals2 = new Queue<>(13);
        setUp(animals2);
        Queue<? extends Feline> felineQueue = Main.produce(animals2);
        List<Queue<Feline>> queues = Main.consume(felineQueue);
        Queue<? super Tiger> ancestorsTiger = queues.get(0);
        Queue<? super Tiger> ancestorsForestCat = queues.get(1);
        while (!ancestorsTiger.isEmpty()) {
            var temp = ancestorsTiger.get();
            assertTrue(!(temp instanceof Cats) && !(temp instanceof Lion));
            assertTrue(temp instanceof Feline);
        }
        while (!ancestorsForestCat.isEmpty()) {
            var temp = ancestorsForestCat.get();
            assertTrue(!(temp instanceof Panther) && !(temp instanceof DomesticCat));
            assertTrue(temp instanceof Feline);
        }
    }

}
