from Lesson2.Vehicle import Vehicle


class Car(Vehicle):
    def __init__(self):
        self.num_wheels = 4
        self.speed = 0

    def get_num_wheels(self):
        return self.num_wheels

    def get_speed(self):
        return self.speed

    def test_drive(self):
        self.speed = 60

    def park(self):
        self.speed = 0
