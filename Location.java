public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location randomAdjacentLocation() {
        int x = getX();
        int y = getY();
        int newX;
        int newY;
        do {
            newX = x + ((int) (Math.random() * 3)) - 1;
            newY = y + ((int) (Math.random() * 3)) - 1;
        } while (newX < 0 || newX >= SimEnvironment.WIDTH || newY < 0 || newY >= SimEnvironment.HEIGHT);
        return new Location(newX, newY);
    }

    public double distanceTo(Location location) {
        int xDiff = x - location.getX();
        int yDiff = y - location.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
