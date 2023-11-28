package second.hw;

public class Car extends Vehicle {
    private int numWheels;
    private int speed;

    public Car() {
        this.numWheels = 4;
        this.speed = 0;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public int getSpeed() {
        return speed;
    }

    public void testDrive() {
        this.speed = 60;
    }

    public void park() {
        this.speed = 0;
    }
}

