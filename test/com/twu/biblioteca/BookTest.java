package com.twu.biblioteca;

import com.twu.biblioteca.mocks.ItemMocks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class BookTest {

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

    private ArrayList<Book> _bookList = ItemMocks.getBookList();

    @Test
    public void printBookDetailsShouldPrintNameYearAndAuthorOnColumns() throws Exception {

        Random random = new Random();

        Book generativeBook = _bookList.get(random.nextInt(_bookList.size()));
        String bookDetails = generativeBook.getDetails();

        assertEquals(bookDetails.isEmpty(), false);
        String[] stringBooks = bookDetails.split("\n");
        assertEquals(stringBooks.length, 1);
    }

}