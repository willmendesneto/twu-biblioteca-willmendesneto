package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Book> _bookList = new ArrayList<Book>();

    public ArrayList<Movie> _movieList = new ArrayList<Movie>();

    public User _userLogged;

    public ArrayList<User> _userList;

    public ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();

    public ArrayList<Movie> _checkedOutMovies = new ArrayList<Movie>();

    public Biblioteca(ArrayList<Book> books, ArrayList<Movie> movies) {
        _bookList = new ArrayList<Book>();

        addBookItems(books);
        addMovieItems(movies);
        addUsers();

    }

    public void addBookItems(ArrayList<Book> books) {

        for (Book book : books){
            _bookList.add(new Book(book.getTitle(), book.getAuthor(), book.getYear()));
        }

    }

    public void addUsers () {
        _userList = new ArrayList<User>() {{
            add(new User("Adrian", "adrian@adrian.com", "+55 71 9999 8888", "111-1111", "1111"));
            add(new User("Bia", "bia@abia.com", "+55 71 2233 8888", "222-2222", "2222"));
            add(new User("Carl", "carl@carl.com", "+55 71 3333 8888", "333-3333", "3333"));
        }};
    }

    public void addMovieItems(ArrayList<Movie> movies) {

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

    public boolean checkoutBook(String bookTitle, String libraryNumber) {
        int position = findAvailableBooksByTitle(bookTitle);
        if (position != -1) {
            Book book = _bookList.get(position);
            book.isCheckedOut = true;
            book.setUserLibraryNumber(libraryNumber);
            _checkedOutBooks.add(book);
            _bookList.remove(position);

            return true;
        }
        return false;

    }

    public boolean checkoutMovie(String movieName, String libraryNumber) {
        int position = findAvailableMoviesByName(movieName);
        if (position != -1) {
            Movie movie = _movieList.get(position);
            movie.isCheckedOut = true;
            movie.setUserLibraryNumber(libraryNumber);

            _checkedOutMovies.add(movie);
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
            _checkedOutBooks.get(position).isCheckedOut = false;
            _bookList.add(_checkedOutBooks.get(position));

            _checkedOutBooks.remove(position);

            return true;
        }
        return false;
    }

    public boolean login(String libraryNumber, String password) {
        int position = findUsersByLibraryNumberAndPassword(libraryNumber, password);
        if (position != - 1) {
            _userList.get(position).isLogged = true;
            _userLogged = _userList.get(position);
            return true;
        }
        return false;
    }

    public User getUserLogged() {
        return _userLogged;
    }


    public boolean logout(String libraryNumber, String password) {
        int position = findUsersByLibraryNumberAndPassword(libraryNumber, password);
        if (position != - 1) {
            _userList.get(position).isLogged = false;
            _userLogged = null;
            return true;
        }
        return false;
    }

    public int findUsersByLibraryNumberAndPassword(String libraryNumber, String password){
        int i = 0;
        int position = -1;

        for (User user : _userList){
            if(user.checkCredentials(libraryNumber, password)){
                position = i;
                break;
            }
            i++;
        }
        return position;
    }

}
