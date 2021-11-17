package tests;

import queue.Queue;
import queue.QueueOverflow;
import queue.QueueUnderflow;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @org.junit.jupiter.api.Test
    void add() {
        Queue<Integer> queue = new Queue<>(1);
        queue.add(5);
        assertThrows(QueueOverflow.class, () -> queue.add(8));
    }

    @org.junit.jupiter.api.Test
    void get() {
        Queue<Integer> queue = new Queue<>(1);
        assertThrows(QueueUnderflow.class, queue::get);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Queue<Integer> queue = new Queue<>(5);
        assertTrue(queue.isEmpty());
        queue.add(5);
        assertFalse(queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getMaxSize() {
        Queue<Integer> queue = new Queue<>(5);
        Queue<Integer> queue2 = new Queue<>(10);
        assertEquals(5, queue.getMaxSize());
        assertEquals(10, queue2.getMaxSize());
        assertThrows(NegativeArraySizeException.class, () -> new Queue<>(-5));
    }
}