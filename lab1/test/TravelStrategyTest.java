package test;

import game.Point;
import game.travelStrategy.TeleportStrategy;
import game.travelStrategy.TravelStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelStrategyTest {
    private final TravelStrategy travelStrategy = new TeleportStrategy();
    private final Point firstPoint = new Point("Moscow", 0, 0);
    private final Point secondPoint = new Point("Paris", 34.8, 89.6);

    @Test
    void getDistanceBetweenPoints() {
        double distance = Math.sqrt(Math.pow((firstPoint.getY() - secondPoint.getY()), 2)
                + Math.pow((firstPoint.getX() - secondPoint.getX()), 2));
        assertEquals(distance, travelStrategy.getDistanceBetweenPoints(firstPoint, secondPoint));
    }
}