import java.util.Random;

public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Location randomAdjacentLocation(double timeStep) {
        Random rand = new Random();
        double x = getX();
        double y = getY();
        double newX;
        double newY;
        double dc = 1;
        do {
            newX = x + rand.nextGaussian() * 2 * dc * timeStep;
            newY = y + rand.nextGaussian() * 2 * dc * timeStep;
        } while (newX < 0 || newX >= SimEnvironment.WIDTH || newY < 0 || newY >= SimEnvironment.HEIGHT);
        return new Location(newX, newY);
    }

    public double distanceTo(Location location) {
        double xDiff = x - location.getX();
        double yDiff = y - location.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
