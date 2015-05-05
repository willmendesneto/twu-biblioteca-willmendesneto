package com.twu.biblioteca.mocks;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Movie;

import java.util.ArrayList;

public final class ItemMocks {

    private static Book _book;
    private static Movie _movie;
    private static ArrayList<Book> _bookList;
    private static ArrayList<Movie> _movieList;

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

    public static String WrongBookTitle = "The True Troller book";
    public static String WrongMovieName = "The True Troller movie";
}
