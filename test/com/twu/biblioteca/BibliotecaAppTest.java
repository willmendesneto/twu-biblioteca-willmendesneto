package com.twu.biblioteca;


import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private BibliotecaApp _bibliotecaApp = new BibliotecaApp();

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
    public void UserShouldSeeAWelcomeMessage() {
        _bibliotecaApp.welcomeMessage();

        assertEquals(MessagesHelper.Welcome + _breakline, outContent.toString());
    }
}