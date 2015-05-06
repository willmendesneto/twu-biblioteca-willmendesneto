package com.twu.biblioteca;

public class Book extends Item {

    private String _title;
    private String _author;
    private int _year;

    public String getTitle() {
        return _title;
    }

    public String getAuthor() {
        return _author;
    }

    public int getYear() {
        return _year;
    }

    public Book(String title, String author, int year) {
        _title = title;
        _author = author;
        _year = year;
    }

    public String getDetails() {

        String whitespaceTitle = String.format("%-30s", _title);
        String whitespaceAuthor = String.format("%-30s", _author);

        return String.format("%s | %s | %s\n",
                                        whitespaceTitle,
                                        whitespaceAuthor,
                                        _year);
    }
}
