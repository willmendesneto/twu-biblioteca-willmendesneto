package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Book> _bookList = new ArrayList<Book>();

    public ArrayList<Movie> _movieList = new ArrayList<Movie>();

    public ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();

    public ArrayList<Movie> _checkedOutMovies = new ArrayList<Movie>();

    public Biblioteca(ArrayList<Book> books, ArrayList<Movie> movies) {
        _bookList = new ArrayList<Book>();

        AddBookItems(books);
        AddMovieItems(movies);

    }

    public void AddBookItems(ArrayList<Book> books) {

        for (Book book : books){
            _bookList.add(new Book(book.getTitle(), book.getAuthor(), book.getYear()));
        }

    }

    public void AddMovieItems(ArrayList<Movie> movies) {

        for (Movie movie : movies){
            _movieList.add(new Movie(movie.getName(), movie.getDirector(), movie.getRate(), movie.getYear()));
        }

    }

    public String getBookListDetails() {
        String booksDetails = "";
        for (Book book : _bookList){
            if (!book.isCheckedOut) {
                booksDetails += book.getDetails();
            }
        }
        return booksDetails;
    }

    public String getMovieListDetails() {
        String moviesDetails = "";
        for (Movie movie : _movieList){
            if (!movie.isCheckedOut) {
                moviesDetails += movie.getDetails();
            }
        }
        return moviesDetails;
    }

    public int bookListMaxLengthString(){
        int max = 0;
        for(Book book : _bookList){
            if (book.getTitle().length() > max ){
                max = book.getTitle().length();
            }

            if (book.getAuthor().length() > max){
                max = book.getAuthor().length();
            }
        }
        return max;
    }


    public boolean checkoutBook(String bookTitle) {
        int position = findAvailableBooksByTitle(bookTitle);
        if (position != -1) {
            _bookList.get(position).isCheckedOut = true;
            _checkedOutBooks.add(_bookList.get(position));
            _bookList.remove(position);

            return true;
        }
        return false;

    }

    public boolean checkoutMovie(String movieName) {
        int position = findAvailableMoviesByName(movieName);
        if (position != -1) {
            _movieList.get(position).isCheckedOut = true;
            _checkedOutMovies.add(_movieList.get(position));
            _movieList.remove(position);

            return true;
        }
        return false;

    }

    public int findMoviesByName(String movieName, ArrayList<Movie> movies){
        int i = 0;
        int position = -1;

        for (Movie movie : movies){
            if(movie.getName().equals(movieName)){
                position = i;
                break;
            }
            i++;
        }
        return position;
    }

    public int findBooksByTitle(String bookTitle, ArrayList<Book> books){
        int i = 0;
        int position = -1;

        for (Book book : books){
            if(book.getTitle().equals(bookTitle)){
                position = i;
                break;
            }
            i++;
        }
        return position;
    }

    public int findCheckedOutMoviesByName(String bookTitle){
        return findMoviesByName(bookTitle, _checkedOutMovies);
    }

    public int findAvailableMoviesByName(String bookTitle){
        return findMoviesByName(bookTitle, _movieList);
    }

    public int findCheckedOutBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _checkedOutBooks);
    }

    public int findAvailableBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _bookList);
    }

    public boolean returnMovie(String movieName) {
        int position = findCheckedOutMoviesByName(movieName);
        if (position != - 1) {
            _checkedOutMovies.get(position).isCheckedOut = false;
            _movieList.add(_checkedOutMovies.get(position));

            _checkedOutMovies.remove(position);

            return true;
        }
        return false;
    }

    public boolean returnBook(String bookTitle) {
        int position = findCheckedOutBooksByTitle(bookTitle);
        if (position != - 1) {
            _checkedOutMovies.get(position).isCheckedOut = false;
            _movieList.add(_checkedOutMovies.get(position));

            _checkedOutMovies.remove(position);

            return true;
        }
        return false;
    }


}
