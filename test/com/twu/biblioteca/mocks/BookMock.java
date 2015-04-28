package com.twu.biblioteca.mocks;

import com.twu.biblioteca.Book;

import java.util.ArrayList;

public final class BookMock {

    private static Book _book;
    private static ArrayList<Book> _bookList;

    public static Book getBook() {
        if (_book == null) {
            _book = new Book("Learning TDD", "Cool Girl", 2015);
        }
        return _book;
    }

    public static ArrayList<Book> getBookList() {
        if (_bookList == null) {
            _bookList = new ArrayList<Book>() {{
                add(new Book("Learning TDD", "Cool Girl", 2015));
                add(new Book("Awesome book", "author with huge name", 2014));
                add(new Book("Another awesome book", "myself", 2013));
            }};
        }
        return _bookList;
    }

    public static String WrongTitle = "The True Troller book";
}
