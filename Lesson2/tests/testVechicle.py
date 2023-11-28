import unittest

from Lesson2.Car import Car
from Lesson2.Motorcycle import Motorcycle
from Lesson2.Vehicle import Vehicle


class VehicleTest(unittest.TestCase):
    # Создает экземпляр объекта типа Car и проверяет,
    # что он также является экземпляром объекта типа
    # Vehicle. Инструкция assertTrue(isinstance(car, Vehicle))
    # выполняет эту проверку.
    def test_car_instance(self):
        car = Car()
        self.assertTrue(isinstance(car, Vehicle))

    # Создает новый экземпляр объекта Car и проверяет,
    # что количество колес у этого автомобиля равно 4.
    # Инструкция self.assertEqual(4, car.get_num_wheels())
    # проверяет это условие.
    def test_car_num_wheels(self):
        car = Car()
        self.assertEqual(4, car.get_num_wheels())

    # Создает новый экземпляр объекта Motorcycle и проверяет,
    # что у этого мотоцикла количество колес равно 2.
    # Инструкция self.assertEqual(2, motorcycle.get_num_wheels())
    # выполняет данную проверку.
    def test_motorcycle_num_wheels(self):
        motorcycle = Motorcycle()
        self.assertEqual(2, motorcycle.get_num_wheels())

    # Создает новый экземпляр объекта Car, вызывает метод test_drive(),
    # и затем проверяет, что скорость автомобиля после тестового
    # вождения составляет 60. Инструкция self.assertEqual(60, car.get_speed())
    # осуществляет данную проверку.
    def test_car_speed_after_test_drive(self):
        car = Car()
        car.test_drive()
        self.assertEqual(60, car.get_speed())

    # Создает новый экземпляр объекта Motorcycle, вызывает метод test_drive(),
    # и затем проверяет, что скорость мотоцикла после тестового вождения
    # составляет 75. Инструкция self.assertEqual(75, motorcycle.get_speed())
    # выполняет эту проверку.
    def test_motorcycle_speed_after_test_drive(self):
        motorcycle = Motorcycle()
        motorcycle.test_drive()
        self.assertEqual(75, motorcycle.get_speed())

    # Создает новый экземпляр объекта Car, вызывает метод test_drive()
    # для эмуляции тестового вождения, затем вызывает метод park()
    # и проверяет, что скорость автомобиля после остановки составляет 0.
    # Инструкция self.assertEqual(0, car.get_speed()) осуществляет данную проверку.
    def test_car_speed_after_parking(self):
        car = Car()
        car.test_drive()
        car.park()
        self.assertEqual(0, car.get_speed())

    # Создает новый экземпляр объекта Motorcycle,
    # вызывает метод test_drive() для эмуляции тестового вождения,
    # затем вызывает метод park() и проверяет, что скорость
    # мотоцикла после остановки составляет 0.
    # Инструкция self.assertEqual(0, motorcycle.get_speed())
    # выполняет данную проверку.
    def test_motorcycle_speed_after_parking(self):
        motorcycle = Motorcycle()
        motorcycle.test_drive()
        motorcycle.park()
        self.assertEqual(0, motorcycle.get_speed())

if __name__ == '__main__':
    unittest.main()
