import pytest

class ListComparator:
    def calculate_mean(self, num_list):
        if len(num_list) == 0:
            return 0
        return sum(num_list) / len(num_list)

    def compare_lists(self, list1, list2):
        mean1 = self.calculate_mean(list1)
        mean2 = self.calculate_mean(list2)
        if mean1 > mean2:
            return "Первый список имеет большее среднее значение"
        elif mean2 > mean1:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"