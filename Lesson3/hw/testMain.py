import unittest
from main import MainHW


class TestMainHW(unittest.TestCase):

    # проверяет, возвращает ли функция is_even()
    # правильный результат для положительных чисел.
    def test_is_even(self):
        self.assertTrue(MainHW.is_even(4))
        self.assertFalse(MainHW.is_even(7))


    # проверяет, возвращает ли функция is_in_range()
    # правильный результат для положительных чисел.
    def test_is_in_range(self):
        self.assertTrue(MainHW.is_in_range(50))
        self.assertFalse(MainHW.is_in_range(20))

    # проверяет, возвращает ли функция is_even()
    # правильный результат для отрицательных чисел.
    def test_is_even_negative(self):
        self.assertTrue(MainHW.is_even(-6))
        self.assertFalse(MainHW.is_even(-3))

    #  проверяет, возвращает ли функция is_in_range()
    #  правильный результат для отрицательных чисел.
    def test_is_in_range_negative(self):
        self.assertTrue(MainHW.is_in_range(75))
        self.assertFalse(MainHW.is_in_range(10))

    # проверяет, возвращает ли функция is_even()
    # правильный результат для нуля.
    def test_is_even_zero(self):
        self.assertTrue(MainHW.is_even(0))

    #  проверяет, возвращает ли функция is_in_range()
    #  правильный результат для нуля.
    def test_is_in_range_zero(self):
        self.assertFalse(MainHW.is_in_range(0))

    # проверяет, возвращает ли функция is_even()
    # правильный результат для положительных чисел.
    def test_is_even_positive(self):
        self.assertTrue(MainHW.is_even(4))
        self.assertFalse(MainHW.is_even(7))

    # проверяет, возвращает ли функция is_in_range()
    # правильный результат для положительных чисел.
    def test_is_in_range_positive(self):
        self.assertTrue(MainHW.is_in_range(50))
        self.assertFalse(MainHW.is_in_range(100))


if __name__ == '__main__':
    unittest.main()
