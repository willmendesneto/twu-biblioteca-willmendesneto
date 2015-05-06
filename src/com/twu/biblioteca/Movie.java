package com.twu.biblioteca;

public class Movie extends Item{

    private String _name;
    private String _director;
    private int _year;
    private int _rate;

    public Movie(String name, String director, int year, int rate) {
        _name = name;
        _director = director;
        _year = year;
        _rate = rate;
    }

    public String getDetails() {

        String whitespaceName = String.format("%-30s", _name);
        String whitespaceDirector = String.format("%-30s", _director);

        return String.format("%s | %s | %s | %s\n",
                whitespaceName,
                whitespaceDirector,
                _year,
                _rate);
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
