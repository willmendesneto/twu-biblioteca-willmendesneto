package com.twu.biblioteca;


import com.twu.biblioteca.mocks.ItemMocks;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


import static org.junit.Assert.*;

public class MenuTest {

    private Menu _menu = new Menu();

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
    public void bookListDetailsShouldBePrintedByChoose1OnMenu() throws FileNotFoundException {
        _menu.menuOptions(1);

        String[] bookDetails = outContent.toString().split("\n");
        System.out.println(outContent.toString());
        System.out.println(ItemMocks.getBookList().size());
        assertEquals(bookDetails.length, ItemMocks.getBookList().size());
    }

    @Test
    public void anErrorShouldBeDisplayedForInvalidOptionOnMenu(){
        _menu.menuOptions(10);
        assertEquals(MessagesHelper.OptionIsInvalid + _breakline, outContent.toString());
    }

    @Test
    public void menuShouldBePrinted() throws FileNotFoundException {
        _menu.printMenu();

        String[] menu = MessagesHelper.MenuOptions.split("\n");
        String[] outputSpy = outContent.toString().split("\n");

        assertEquals(menu.length, outputSpy.length);
    }
}
