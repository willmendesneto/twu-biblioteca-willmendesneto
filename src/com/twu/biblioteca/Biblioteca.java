package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Book> _bookList;

    public ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();

    public Biblioteca(ArrayList<Book> books) {
        _bookList = new ArrayList<Book>();

        for (Book book : books){
            _bookList.add(new Book(book.getTitle(), book.getAuthor(), book.getYear()));
        }
    }

    public String getBookListDetails() {
        int length = bookListMaxLengthString();
        String booksDetails = "";
        for (Book book : _bookList){
            if (!book.isCheckedOut) {
                booksDetails += book.getDetails();
            }
        }
        return booksDetails;
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


    public boolean checkout(String bookTitle) {
        int position = findAvailableBooksByTitle(bookTitle);
        if (position != -1) {
            _bookList.get(position).isCheckedOut = true;
            _checkedOutBooks.add(_bookList.get(position));
            _bookList.remove(position);

            return true;
        }
        return false;

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

    public int findCheckedOutBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _checkedOutBooks);
    }

    public int findAvailableBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _bookList);
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


}
