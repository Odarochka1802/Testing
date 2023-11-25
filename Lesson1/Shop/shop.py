from typing import List

from Lesson1.Shop.product import Product


class Shop:
    def __init__(self):
        self._products = []

    @property
    def products(self) -> List[Product]:
        return self._products

    @products.setter
    def products(self, value: List[Product]):
        self._products = value

    def sort_products_by_price(self) -> List[Product]:
        return sorted(self._products, key=lambda x: x.cost)

    def get_most_expensive_product(self) -> Product:
        if not self._products:
            return None
        return max(self._products, key=lambda x: x.cost)
