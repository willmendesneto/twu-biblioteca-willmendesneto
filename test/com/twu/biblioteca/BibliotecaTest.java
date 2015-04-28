package com.twu.biblioteca;


import com.twu.biblioteca.mocks.BookMock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;


import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca _biblioteca = new Biblioteca(BookMock.getBookList());

    private String _breakline = "\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void bookListDetailsShouldPrintedAsColumns() throws FileNotFoundException {
        System.setOut(null);
        String bookDetailsMock = "";
        ArrayList<Book> bookList = BookMock.getBookList();

        int length = _biblioteca.bookListMaxLengthString();
        for (Book book : bookList){
            bookDetailsMock += book.getDetails();
        }

        assertEquals(bookDetailsMock, _biblioteca.getBookListDetails());
    }

    @Test
    public void bibliotecaShouldFindThePositionForAVailableBookName(){
        assertEquals(2, _biblioteca.findAvailableBooksByTitle("Another awesome book"));
    }

    @Test
    public  void bookShouldBeRemovedFromBookListAfterCheckout() {
        assertEquals(true, _biblioteca.checkout("Another awesome book"));
    }

    @Test
    public void successAfterSuccessfulCheckout(){

        assertEquals(true, _biblioteca.checkout("Another awesome book"));
        assertEquals(false, _biblioteca.checkout("Another awesome book"));
    }

    @Test
    public void unccessfulAfterAnsuccessfulCheckout(){
        _biblioteca.checkout(BookMock.WrongTitle);

        assertEquals(false, _biblioteca.checkout(BookMock.WrongTitle));
    }

    @Test
    public void bookShouldBeAddedToBookListAfterReturnBook(){
        Book book = BookMock.getBook();

        _biblioteca.checkout(book.getTitle());
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }

    @Test
    public void shouldBeReturnTrueAfterSuccessfulReturnBook(){
        Book book = BookMock.getBook();

        assertEquals(true, _biblioteca.checkout(book.getTitle()));
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }

    @Test
    public void unccessfullAfterAnUnsuccessfulReturn(){
        assertEquals(false,  _biblioteca.returnBook(BookMock.WrongTitle));
    }
}
