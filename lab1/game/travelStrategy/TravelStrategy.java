package game.travelStrategy;

import game.Hero;
import game.Point;

public interface TravelStrategy {
    void move(final Point place, Hero hero);

    default double getDistanceBetweenPoints(final Point firstPoint, final Point secondPoint) {
        return Math.sqrt(Math.pow((firstPoint.getY() - secondPoint.getY()), 2)
                + Math.pow((firstPoint.getX() - secondPoint.getX()), 2));
    }

    default void printInfo(final Hero hero, final double distance, final double speed, final Point place) {
        System.out.print("Hero " + hero.getName() + " came to city " + place.getName() + " (");
        System.out.printf("%.2f", distance);
        System.out.print(" km)" + " with speed ");
        System.out.printf("%.2f", speed);
        System.out.println(" km/h");
    }
}
