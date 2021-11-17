package test;

import game.Hero;
import game.Point;
import game.travelStrategy.TeleportStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private final Hero hero = new Hero("Nastia");
    private final Point place = new Point("Polytech", 34.8, 89.6);

    public void setUp() {
        hero.setActualTravelStrategy(new TeleportStrategy());
        hero.move(place);
    }

    @Test
    public void move() {
        hero.setActualTravelStrategy(new TeleportStrategy());
        hero.move(place);
        assertEquals("Polytech", hero.getPlace().getName());
        assertEquals(34.8, hero.getPlace().getX());
        assertEquals(89.6, hero.getPlace().getY());
        assertEquals(place, hero.getPlace());
        double distance = Math.sqrt(Math.pow((hero.getPlace().getY() - 0.0), 2)
                + Math.pow((hero.getPlace().getX() - 0.0), 2));
        assertEquals(distance, hero.getWay());
        assertEquals(1, hero.getCountOfPointsVisited());
        assertEquals(0, hero.getSumOfSpeeds());
    }

    @Test
    public void getPlace() {
        setUp();
        assertEquals(place, hero.getPlace());
    }

    @Test
    public void getName() {
        assertEquals("Nastia", hero.getName());
    }

    @Test
    void getWay() {
        setUp();
        double distance = Math.sqrt(Math.pow((hero.getPlace().getY() - 0.0), 2)
                + Math.pow((hero.getPlace().getX() - 0.0), 2));
        assertEquals(distance, hero.getWay());
    }

    @Test
    void getCountOfPointsVisited() {
        setUp();
        assertEquals(1, hero.getCountOfPointsVisited());
    }

    @Test
    void getSumOfSpeeds() {
        setUp();
        assertEquals(0, hero.getSumOfSpeeds());
    }
}