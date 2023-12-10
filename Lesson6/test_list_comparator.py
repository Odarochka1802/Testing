from list_comparator import ListComparator


def test_compare_lists_mean1_greater():
    """
    Тест для сравнения списков, где среднее значение первого списка больше.
    """
    lc = ListComparator()
    list1 = [1, 2, 3, 4, 5]
    list2 = [1, 2, 3, 4]
    assert lc.compare_lists(list1, list2) == "Первый список имеет большее среднее значение"

def test_compare_lists_mean2_greater():
    """
    Тест для сравнения списков, где среднее значение второго списка больше.
    """
    lc = ListComparator()
    list1 = [1, 2, 3]
    list2 = [1, 2, 3, 4, 5]
    assert lc.compare_lists(list1, list2) == "Второй список имеет большее среднее значение"

def test_compare_lists_equal_means():
    """
    Тест для сравнения списков, где средние значения равны.
    """
    lc = ListComparator()
    list1 = [1, 2, 3, 4]
    list2 = [1, 2, 3, 4]
    assert lc.compare_lists(list1, list2) == "Средние значения равны"

def test_compare_lists_empty_lists():
    """
    Тест для сравнения пустых списков.
    """
    lc = ListComparator()
    list1 = []
    list2 = []
    assert lc.compare_lists(list1, list2) == "Средние значения равны"

def test_calculate_mean_empty_list():
    """
    Тест для вычисления среднего значения пустого списка.
    """
    lc = ListComparator()
    num_list = []
    assert lc.calculate_mean(num_list) == 0

def test_calculate_mean_non_empty_list():
    """
    Тест для вычисления среднего значения непустого списка.
    """
    lc = ListComparator()
    num_list = [1, 2, 3, 4, 5]
    assert lc.calculate_mean(num_list) == 3.0


