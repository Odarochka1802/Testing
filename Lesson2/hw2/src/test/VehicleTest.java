package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import second.hw.Car;
import second.hw.Motorcycle;
import second.hw.Vehicle;

public class VehicleTest {
    //Создает экземпляр объекта типа Car и проверяет,
    // что он также является экземпляром объекта типа
    // Vehicle. Инструкция assertTrue(car instanceof
    // Vehicle) выполняет эту проверку.
    @Test
    public void testCarInstance() {
        Car car = new Car();
        assertTrue(car instanceof Vehicle);
    }

    //Создает новый экземпляр объекта Car и проверяет,
    // что количество колес у этого автомобиля равно 4.
    // Инструкция assertEquals(4, car.getNumWheels())
    // проверяет это условие.
    @Test
    public void testCarNumWheels() {
        Car car = new Car();
        assertEquals(4, car.getNumWheels());
    }

    //Создает новый экземпляр объекта Motorcycle и проверяет,
    // что у этого мотоцикла количество колес равно 2.
    // Инструкция assertEquals(2, motorcycle.getNumWheels())
    // выполняет данную проверку.
    @Test
    public void testMotorcycleNumWheels() {
        Motorcycle motorcycle = new Motorcycle();
        assertEquals(2, motorcycle.getNumWheels());
    }

    //Создает новый экземпляр объекта Car, вызывает метод testDrive(),
    // и затем проверяет, что скорость автомобиля после тестового
    // вождения составляет 60. Инструкция assertEquals(60, car.getSpeed())
    // осуществляет данную проверку.
    @Test
    public void testCarSpeedAfterTestDrive() {
        Car car = new Car();
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    //Создает новый экземпляр объекта Motorcycle, вызывает метод testDrive(),
    // и затем проверяет, что скорость мотоцикла после тестового вождения
    // составляет 75. Инструкция assertEquals(75, motorcycle.getSpeed())
    // выполняет эту проверку.
    @Test
    public void testMotorcycleSpeedAfterTestDrive() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    //Создает новый экземпляр объекта Car, вызывает метод testDrive()
    // для эмуляции тестового вождения, затем вызывает метод park()
    // и проверяет, что скорость автомобиля после остановки составляет 0.
    // Инструкция assertEquals(0, car.getSpeed()) осуществляет данную проверку.
    @Test
    public void testCarSpeedAfterParking() {
        Car car = new Car();
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    //Создает новый экземпляр объекта Motorcycle,
    // вызывает метод testDrive() для эмуляции тестового вождения,
    // затем вызывает метод park() и проверяет, что скорость
    // мотоцикла после остановки составляет 0.
    // Инструкция assertEquals(0, motorcycle.getSpeed())
    // выполняет данную проверку.
    @Test
    public void testMotorcycleSpeedAfterParking() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
