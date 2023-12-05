namespace Lesson5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest
    {
    @Test
    public void testContactCreation()
        {
            // Создание экземпляра записной книжки
            AddressBook addressBook = new AddressBook();

            // Создание нового контакта
            Contact newContact = new Contact("Имя", "example@email.com", "123-456-7890");

            // Добавление контакта в записную книжку
            addressBook.addContact(newContact);

            // Проверка, что контакт был успешно добавлен
            assertTrue(addressBook.getContacts().contains(newContact));
        }
    @Test
    public void testContactEditing()
    {
        // Создание экземпляра записной книжки
        AddressBook addressBook = new AddressBook();

        // Создание и добавление нового контакта
        Contact newContact = new Contact("Имя", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // Редактирование информации о контакте
        newContact.setName("Новое имя");
        newContact.setEmail("new@example.com");

        // Сохранение изменений в записной книжке
        addressBook.updateContact(newContact);

        // Получаем отредактированный контакт из записной книжки
        Contact editedContact = addressBook.getContactById(newContact.getId());

        // Проверяем, что контакт действительно отредактирован
        assertEquals("Новое имя", editedContact.getName());
        assertEquals("new@example.com", editedContact.getEmail());
    }
    @Test
    public void testContactDeletion()
    {
        // Создание экземпляра записной книжки
        AddressBook addressBook = new AddressBook();

        // Создание и добавление нового контакта
        Contact newContact = new Contact("Имя", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // Удаление контакта
        addressBook.deleteContact(newContact.getId());

        // Проверяем, что контакт был удален
        assertFalse(addressBook.getContacts().contains(newContact));
        assertNull(addressBook.getContactById(newContact.getId()));
    }

}

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AddressBookTest
{

    @Test
    public void testContactPersistence()
    {
        // Создаем временный файл базы данных для записной книжки
        File tempDatabaseFile = createTempDatabaseFile();

        // Создаем записную книжку, используя временный файл базы данных
        AddressBook addressBook = new AddressBook(tempDatabaseFile);

        // Создаем новый контакт и добавляем его в записную книжку
        Contact newContact = new Contact("Имя", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // Закрываем текущий экземпляр записной книжки
        addressBook.close();

        // Создаем новую записную книжку, используя тот же временный файл базы данных
        AddressBook reopenedAddressBook = new AddressBook(tempDatabaseFile);

        // Проверяем, что добавленный контакт по-прежнему присутствует после перезапуска записной книжки
        assertTrue(reopenedAddressBook.getContacts().contains(newContact));

        // Удаляем временный файл базы данных после завершения теста
        tempDatabaseFile.delete();
    }

    private File createTempDatabaseFile()
    {
        // Реализация создания временного файла базы данных
        // ...
        return temporaryFile;
    }
    @Test
    public void testContactListDisplay()
    {
        // Создаем экземпляр записной книжки
        AddressBook addressBook = new AddressBook();

        // Создаем несколько тестовых контактов
        Contact contact1 = new Contact("Иванов", "ivanov@example.com", "123-456-7890");
        Contact contact2 = new Contact("Петров", "petrov@example.com", "234-567-8901");
        Contact contact3 = new Contact("Сидоров", "sidorov@example.com", "345-678-9012");

        // Добавляем контакты в записную книжку
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);

        // Получаем список контактов из записной книжки
        List<Contact> contacts = addressBook.getContacts();

        // Проверяем, что список контактов содержит верное количество контактов
        assertEquals(3, contacts.size());

        // Проверяем, что контакты отображаются в ожидаемом порядке
        assertEquals("Иванов", contacts.get(0).getName());
        assertEquals("Петров", contacts.get(1).getName());
        assertEquals("Сидоров", contacts.get(2).getName());
    }
    @Test
    public void testContactSearchFunctionality()
    {
        // Создаем записную книжку
        AddressBook addressBook = new AddressBook();

        // Создаем несколько тестовых контактов
        Contact contact1 = new Contact("Иванов Иван", "ivanov@example.com", "123-456-7890");
        Contact contact2 = new Contact("Петров Петр", "petrov@example.com", "234-567-8901");
        Contact contact3 = new Contact("Сидоров Алексей", "sidorov@example.com", "345-678-9012");

        // Добавляем контакты в записную книжку
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);

        // Проверяем поиск контакта по имени
        Contact foundContact = addressBook.searchContact("Петров");
        assertEquals("Петров Петр", foundContact.getName());

        // Проверяем поиск контакта по номеру телефона
        foundContact = addressBook.searchContact("234-567-8901");
        assertEquals("Петров Петр", foundContact.getName());
    }
    @Test
    public void testContactDuplicationPrevention()
    {
        // Создаем записную книжку
        AddressBook addressBook = new AddressBook();

        // Создание нового контакта
        Contact newContact = new Contact("Иванов Иван", "ivanov@example.com", "123-456-7890");

        // Добавляем контакт в записную книжку
        addressBook.addContact(newContact);

        // Пытаемся добавить дублирующий контакт
        Contact duplicateContact = new Contact("Иванов Иван", "newemail@example.com", "999-999-9999");
        addressBook.addContact(duplicateContact);

        // Проверяем, что дублирующий контакт не был добавлен
        assertNull(addressBook.getContactById(duplicateContact.getId()));
    }
    @Test
    public void testContactSorting()
    {
        // Создаем экземпляр записной книжки
        AddressBook addressBook = new AddressBook();

        // Создаем контакты с различными именами (для наглядности сортировки)
        Contact contact1 = new Contact("Денисов", "denisov@example.com", "123-456-7890");
        Contact contact2 = new Contact("Антонов", "antonov@example.com", "234-567-8901");
        Contact contact3 = new Contact("Баранов", "baranov@example.com", "345-678-9012");

        // Добавляем контакты в записную книжку в произвольном порядке
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        addressBook.addContact(contact1);

        // Получаем отсортированный список контактов
        List<Contact> sortedContacts = addressBook.getSortedContacts();

        // Проверяем, что контакты отображаются в ожидаемом порядке (по алфавиту)
        assertEquals("Антонов", sortedContacts.get(0).getName());
        assertEquals("Баранов", sortedContacts.get(1).getName());
        assertEquals("Денисов", sortedContacts.get(2).getName());
    }
}



