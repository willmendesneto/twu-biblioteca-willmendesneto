package com.twu.biblioteca;

public class Movie {

    private String _name;
    private String _director;
    public boolean isCheckedOut;
    private int _year;
    private int _rate;

    public Movie(String name, String director, int year, int rate) {
        _name = name;
        _director = director;
        _year = year;
        _rate = rate;
        isCheckedOut = false;
    }

    public String getDetails() {

        String whitespaceName = String.format("%-30s", _name);
        String whitespaceDirector = String.format("%-30s", _director);

        return String.format("%s | %s | %s | %s\n",
                whitespaceName,
                whitespaceDirector,
                _rate,
                _year);
    }

    public String getName() {
        return _name;
    }

    public String getDirector() {
        return _director;
    }

    public int getYear() {
        return _year;
    }

    public int getRate() {
        return _rate;
    }
}
