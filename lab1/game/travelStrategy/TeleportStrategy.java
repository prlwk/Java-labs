package game.travelStrategy;

import game.Hero;
import game.Point;

public class TeleportStrategy implements TravelStrategy {
    static final double SPEED;

    static {
        SPEED = 0.0;
    }

    @Override
    public void move(final Point place, Hero hero) {
        double distance = getDistanceBetweenPoints(place, hero.getPlace());
        hero.addWay(distance);
        hero.addSpeed(SPEED);
        printInfo(hero, distance, SPEED, place);
    }
}
