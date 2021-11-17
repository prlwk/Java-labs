package test;

import game.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private final Point[] points = new Point[3];
    private final double[] xCoordinates = {-98.5, 968.5, 8.5};
    private final double[] yCoordinates = {-8.5, 9778.5, -78.5};
    private final String[] names = {"Polytech", "Lesnaya", "Academicheskaya"};

    public void setUp() {
        points[0] = new Point("Polytech", -98.5, -8.5);
        points[1] = new Point("Lesnaya", 968.5, 9778.5);
        points[2] = new Point("Academicheskaya", 8.5, -78.5);
    }

    @Test
    public void getX() {
        setUp();
        for (int i = 0; i < 3; i++) {
            assertEquals(points[i].getX(), xCoordinates[i]);
        }
    }

    @Test
    public void getY() {
        setUp();
        for (int i = 0; i < 3; i++) {
            assertEquals(points[i].getY(), yCoordinates[i]);
        }
    }

    @Test
    public void getName() {
        setUp();
        for (int i = 0; i < 3; i++) {
            assertEquals(points[i].getName(), names[i]);
        }
    }
}