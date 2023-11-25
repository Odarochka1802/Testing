import math


class Calculator:

    @staticmethod
    def calculation(first_operand, second_operand, operator):
        if operator == '+':
            return first_operand + second_operand
        elif operator == '-':
            return first_operand - second_operand
        elif operator == '*':
            return first_operand * second_operand
        elif operator == '/':
            if second_operand != 0:
                return first_operand / second_operand
            else:
                raise ZeroDivisionError("Division by zero is not possible")
        else:
            raise ValueError("Unexpected operator: " + operator)

    @staticmethod
    def square_root_extraction(num):
        if num < 0:
            raise ValueError("Cannot calculate square root of a negative number")
        result = math.sqrt(num)
        return round(result, 2) if not result.is_integer() else int(result)

    @staticmethod
    def calculating_discount(purchase_amount, discount_amount):
        if purchase_amount < 0 or discount_amount < 0 or discount_amount > 100:
            raise ValueError("Invalid input: purchase amount and discount amount must be non-negative, and discount amount must be between 0 and 100")
        discount = purchase_amount * discount_amount / 100.0
        return purchase_amount - discount
