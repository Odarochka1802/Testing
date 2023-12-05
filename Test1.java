namespace Lesson5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest
    {
    @Test
    public void testContactCreation()
        {
            // �������� ���������� �������� ������
            AddressBook addressBook = new AddressBook();

            // �������� ������ ��������
            Contact newContact = new Contact("���", "example@email.com", "123-456-7890");

            // ���������� �������� � �������� ������
            addressBook.addContact(newContact);

            // ��������, ��� ������� ��� ������� ��������
            assertTrue(addressBook.getContacts().contains(newContact));
        }
    @Test
    public void testContactEditing()
    {
        // �������� ���������� �������� ������
        AddressBook addressBook = new AddressBook();

        // �������� � ���������� ������ ��������
        Contact newContact = new Contact("���", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // �������������� ���������� � ��������
        newContact.setName("����� ���");
        newContact.setEmail("new@example.com");

        // ���������� ��������� � �������� ������
        addressBook.updateContact(newContact);

        // �������� ����������������� ������� �� �������� ������
        Contact editedContact = addressBook.getContactById(newContact.getId());

        // ���������, ��� ������� ������������� ��������������
        assertEquals("����� ���", editedContact.getName());
        assertEquals("new@example.com", editedContact.getEmail());
    }
    @Test
    public void testContactDeletion()
    {
        // �������� ���������� �������� ������
        AddressBook addressBook = new AddressBook();

        // �������� � ���������� ������ ��������
        Contact newContact = new Contact("���", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // �������� ��������
        addressBook.deleteContact(newContact.getId());

        // ���������, ��� ������� ��� ������
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
        // ������� ��������� ���� ���� ������ ��� �������� ������
        File tempDatabaseFile = createTempDatabaseFile();

        // ������� �������� ������, ��������� ��������� ���� ���� ������
        AddressBook addressBook = new AddressBook(tempDatabaseFile);

        // ������� ����� ������� � ��������� ��� � �������� ������
        Contact newContact = new Contact("���", "example@email.com", "123-456-7890");
        addressBook.addContact(newContact);

        // ��������� ������� ��������� �������� ������
        addressBook.close();

        // ������� ����� �������� ������, ��������� ��� �� ��������� ���� ���� ������
        AddressBook reopenedAddressBook = new AddressBook(tempDatabaseFile);

        // ���������, ��� ����������� ������� ��-�������� ������������ ����� ����������� �������� ������
        assertTrue(reopenedAddressBook.getContacts().contains(newContact));

        // ������� ��������� ���� ���� ������ ����� ���������� �����
        tempDatabaseFile.delete();
    }

    private File createTempDatabaseFile()
    {
        // ���������� �������� ���������� ����� ���� ������
        // ...
        return temporaryFile;
    }
    @Test
    public void testContactListDisplay()
    {
        // ������� ��������� �������� ������
        AddressBook addressBook = new AddressBook();

        // ������� ��������� �������� ���������
        Contact contact1 = new Contact("������", "ivanov@example.com", "123-456-7890");
        Contact contact2 = new Contact("������", "petrov@example.com", "234-567-8901");
        Contact contact3 = new Contact("�������", "sidorov@example.com", "345-678-9012");

        // ��������� �������� � �������� ������
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);

        // �������� ������ ��������� �� �������� ������
        List<Contact> contacts = addressBook.getContacts();

        // ���������, ��� ������ ��������� �������� ������ ���������� ���������
        assertEquals(3, contacts.size());

        // ���������, ��� �������� ������������ � ��������� �������
        assertEquals("������", contacts.get(0).getName());
        assertEquals("������", contacts.get(1).getName());
        assertEquals("�������", contacts.get(2).getName());
    }
    @Test
    public void testContactSearchFunctionality()
    {
        // ������� �������� ������
        AddressBook addressBook = new AddressBook();

        // ������� ��������� �������� ���������
        Contact contact1 = new Contact("������ ����", "ivanov@example.com", "123-456-7890");
        Contact contact2 = new Contact("������ ����", "petrov@example.com", "234-567-8901");
        Contact contact3 = new Contact("������� �������", "sidorov@example.com", "345-678-9012");

        // ��������� �������� � �������� ������
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);

        // ��������� ����� �������� �� �����
        Contact foundContact = addressBook.searchContact("������");
        assertEquals("������ ����", foundContact.getName());

        // ��������� ����� �������� �� ������ ��������
        foundContact = addressBook.searchContact("234-567-8901");
        assertEquals("������ ����", foundContact.getName());
    }
    @Test
    public void testContactDuplicationPrevention()
    {
        // ������� �������� ������
        AddressBook addressBook = new AddressBook();

        // �������� ������ ��������
        Contact newContact = new Contact("������ ����", "ivanov@example.com", "123-456-7890");

        // ��������� ������� � �������� ������
        addressBook.addContact(newContact);

        // �������� �������� ����������� �������
        Contact duplicateContact = new Contact("������ ����", "newemail@example.com", "999-999-9999");
        addressBook.addContact(duplicateContact);

        // ���������, ��� ����������� ������� �� ��� ��������
        assertNull(addressBook.getContactById(duplicateContact.getId()));
    }
    @Test
    public void testContactSorting()
    {
        // ������� ��������� �������� ������
        AddressBook addressBook = new AddressBook();

        // ������� �������� � ���������� ������� (��� ����������� ����������)
        Contact contact1 = new Contact("�������", "denisov@example.com", "123-456-7890");
        Contact contact2 = new Contact("�������", "antonov@example.com", "234-567-8901");
        Contact contact3 = new Contact("�������", "baranov@example.com", "345-678-9012");

        // ��������� �������� � �������� ������ � ������������ �������
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        addressBook.addContact(contact1);

        // �������� ��������������� ������ ���������
        List<Contact> sortedContacts = addressBook.getSortedContacts();

        // ���������, ��� �������� ������������ � ��������� ������� (�� ��������)
        assertEquals("�������", sortedContacts.get(0).getName());
        assertEquals("�������", sortedContacts.get(1).getName());
        assertEquals("�������", sortedContacts.get(2).getName());
    }
}



