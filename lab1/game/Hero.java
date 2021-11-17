package game;

import game.travelStrategy.TravelStrategy;

public class Hero {
    private final String name;
    private Point place = new Point("Start", 0, 0);
    private double way = 0.0;
    private int countOfPointsVisited = 0;
    private double sumOfSpeeds = 0.0;
    private TravelStrategy actualTravelStrategy = null;

    public Hero() {
        this.name = "noname";
    }

    public Hero(final String name) {
        if (name!=null) {
            this.name = name;
        }
        else
        {
            throw new NullPointerException();
        }
    }

    public void move(final Point place) {
        if (actualTravelStrategy != null) {
            actualTravelStrategy.move(place, this);
            this.place = place;
            countOfPointsVisited++;
        } else {
            throw new NullPointerException();
        }
    }

    public void addWay(final double way) {
        this.way += way;
    }

    public void addSpeed(double speed) {
        this.sumOfSpeeds += speed;
    }

    public Point getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public double getWay() {
        return way;
    }

    public int getCountOfPointsVisited() {
        return countOfPointsVisited;
    }

    public double getSumOfSpeeds() {
        return sumOfSpeeds;
    }

    public void setActualTravelStrategy(TravelStrategy actualTravelStrategy) {
        if (actualTravelStrategy != null) {
            this.actualTravelStrategy = actualTravelStrategy;
        } else {
            throw new NullPointerException();
        }
    }
}
