package Test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

	@Test
    public void testFindBookById() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book expectedBook = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        // Act
        Book result = bookService.findBookById("1");

        // Assert
        assertEquals(expectedBook, result);
    }

	@Test
    public void testFindAllBooks() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertEquals(expectedBooks, result);
    }
}
