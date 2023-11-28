from abc import ABC, abstractmethod

class Vehicle(ABC):
    @abstractmethod
    def test_drive(self):
        pass

    @abstractmethod
    def park(self):
        pass
