import unittest
from Calculator import Calculator
import math

class TestCalculator(unittest.TestCase):

    def test_calculation_with_integers(self):
        self.assertEqual(Calculator.calculation(2, 6, '+'), 8)
        self.assertEqual(Calculator.calculation(2, 2, '-'), 0)
        self.assertEqual(Calculator.calculation(2, 7, '*'), 14)
        self.assertEqual(Calculator.calculation(100, 50, '/'), 2)

    def test_calculation_with_invalid_operator(self):
        with self.assertRaises(ValueError) as context:
            Calculator.calculation(8, 4, '_')
        self.assertEqual(str(context.exception), "Unexpected operator: _")

    def test_square_root_extraction(self):
        self.assertEqual(Calculator.square_root_extraction(169), 13.0)

    def test_calculation_with_invalid_inputs(self):
        with self.assertRaises(ValueError) as context:
            Calculator.calculating_discount(-100, 20)
        self.assertEqual(str(context.exception),
                         "Invalid input: purchase amount and discount amount must be non-negative, and discount amount must be between 0 and 100")


if __name__ == '__main__':
    unittest.main()
