import unittest
from Lesson1.Shop.product import Product
from Lesson1.Shop.shop import Shop

class TestShop(unittest.TestCase):
    def setUp(self):
        self.shop = Shop()
        self.products = [
            Product(title='Apple', cost=1.5),
            Product(title='Banana', cost=2.0),
            Product(title='Orange', cost=1.75)
        ]
        self.shop.products = self.products

    def test_correct_product_storage(self):
        self.assertEqual(len(self.shop.products), len(self.products))
        for idx, product in enumerate(self.shop.products):
            self.assertEqual(product.title, self.products[idx].title)
            self.assertEqual(product.cost, self.products[idx].cost)

    def test_get_most_expensive_product(self):
        most_expensive = self.shop.get_most_expensive_product()
        self.assertEqual(most_expensive.title, 'Banana')  # Assuming 'Banana' is the most expensive here

    def test_sort_products_by_price(self):
        sorted_products = self.shop.sort_products_by_price()
        self.assertEqual(sorted_products[0].title, 'Apple')  # Assuming 'Apple' has the lowest cost
        self.assertEqual(sorted_products[-1].title, 'Banana')  # Assuming 'Banana' has the highest cost


if __name__ == '__main__':
    unittest.main()
