package game;

public class Point {
    private double x = 0.0;
    private double y = 0.0;
    private String name = "noname";

    public Point(final String name, final double x, final double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}
