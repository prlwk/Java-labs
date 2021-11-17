package game.travelStrategy;

import game.Hero;
import game.Point;

public class WalkingStrategy implements TravelStrategy {
    private double speed = 0;
    private final double coefficient = 3.0;

    @Override
    public void move(final Point place, Hero hero) {
        speed = Math.random() * coefficient + coefficient;
        double distance = getDistanceBetweenPoints(place, hero.getPlace());
        hero.addWay(distance);
        hero.addSpeed(speed);
        printInfo(hero, distance, speed, place);
    }
}
