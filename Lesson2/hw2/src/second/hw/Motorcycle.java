package second.hw;

public class Motorcycle extends Vehicle {
    private int numWheels;
    private int speed;

    public Motorcycle() {
        this.numWheels = 2;
        this.speed = 0;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public int getSpeed() {
        return speed;
    }

    public void testDrive() {
        this.speed = 75;
    }

    public void park() {
        this.speed = 0;
    }
}