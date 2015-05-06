package com.twu.biblioteca.mocks;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.User;

import java.util.ArrayList;

public final class ItemMocks {

    private static Book _book;
    private static Movie _movie;
    private static User _user;
    private static ArrayList<Book> _bookList;
    private static ArrayList<Movie> _movieList;
    private static ArrayList<User> _userList;

    public static Book getBook() {
        if (_book == null) {
            _book = new Book("Learning TDD", "Cool Girl", 2015);
        }
        return _book;
    }

    public static ArrayList<Book> getBookList() {
        if (_bookList == null) {
            _bookList = new ArrayList<Book>() {{
                add(getBook());
                add(new Book("Awesome book", "author with huge name", 2014));
                add(new Book("Another awesome book", "myself", 2013));
            }};
        }
        return _bookList;
    }

    public static Movie getMovie() {
        if (_movie == null) {
            _movie = new Movie("Jurassic Park", "Spielberg", 2008, 9);
        }
        return _movie;
    }

    public static ArrayList<Movie> getMovieList() {

        if (_movieList == null) {
            _movieList = new ArrayList<Movie>() {{
                add(getMovie());
                add(new Movie("The Butterfly Effect", "Eric Bress", 2004, 7));
                add(new Movie("Saw", "James Wan", 2005, 10));
            }};
        }
        return _movieList;
    }

    public static User getUser() {
        if (_user == null) {
            _user = new User("Adrian", "adrian@adrian.com", "+55 71 9999 8888", "111-1111", "1111");
        }
        return _user;
    }

    public static ArrayList<User> getUserList() {

        if (_userList == null) {
            _userList = new ArrayList<User>() {{
                add(getUser());
                add(new User("Bia", "bia@abia.com", "+55 71 2233 8888", "222-2222", "2222"));
                add(new User("Carl", "carl@carl.com", "+55 71 3333 8888", "333-3333", "3333"));
            }};
        }
        return _userList;
    }

    public static String WrongBookTitle = "The True Troller book";
    public static String WrongMovieName = "The True Troller movie";
}
