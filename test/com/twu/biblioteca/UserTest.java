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

public class UserTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Biblioteca _biblioteca = new Biblioteca(ItemMocks.getBookList(), ItemMocks.getMovieList());

    private User user = ItemMocks.getUser();

    private ArrayList<User> _userList = ItemMocks.getUserList();

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
    public void userShouldBeLoggedWhenPassCorrectInformations() {
        _biblioteca.login(user.getLibraryNumber(), user.getPassword());
        User userLogged = _biblioteca.getUserLogged();
        assertEquals(true, userLogged.isLogged);
        assertEquals(true, userLogged.getDetails().equals(user.getDetails()));
        assertEquals(true, userLogged.getEmail().equals(user.getEmail()));
        assertEquals(true, userLogged.getLibraryNumber().equals(user.getLibraryNumber()));
        assertEquals(true, userLogged.getPassword().equals(user.getPassword()));
        assertEquals(true, userLogged.checkCredentials(user.getLibraryNumber(),user.getPassword()));
    }


    @Test
    public void userShouldBeReturnFalseWhenPassIncorrectInformations() {
        _biblioteca.login("Something else", user.getPassword());
        User userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);

        _biblioteca.login(user.getLibraryNumber(), "Something else");
        userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);

        _biblioteca.login("Something else", "Something else");
        userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);
    }


    @Test
    public void printUserDetailsShouldPrintNameEmailPhoneOnColumns() throws Exception {

        Random random = new Random();

        User generativeUser = _userList.get(random.nextInt(_userList.size()));
        String userDetails = generativeUser.getDetails();

        assertEquals(userDetails.isEmpty(), false);

        String[] stringBooks = userDetails.split("\n");
        assertEquals(stringBooks.length, 3);

        assertEquals(true, userDetails.contains(generativeUser.getName()));
        assertEquals(true, userDetails.contains(generativeUser.getEmail()));
        assertEquals(true, userDetails.contains(generativeUser.getPhone()));
    }

}
