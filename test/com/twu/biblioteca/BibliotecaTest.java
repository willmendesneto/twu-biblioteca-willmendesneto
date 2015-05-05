package com.twu.biblioteca;


import com.twu.biblioteca.mocks.ItemMocks;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;


import static org.junit.Assert.*;

public class BibliotecaTest {

    private Biblioteca _biblioteca = new Biblioteca(ItemMocks.getBookList(), ItemMocks.getMovieList());

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
    public void bookListDetailsShouldPrintedAsColumns() throws FileNotFoundException {
        System.setOut(null);
        String bookDetailsMock = "";
        ArrayList<Book> bookList = ItemMocks.getBookList();

        for (Book book : bookList){
            bookDetailsMock += book.getDetails();
        }

        assertEquals(bookDetailsMock, _biblioteca.getBookListDetails());
    }

    @Test
    public void bibliotecaShouldFindThePositionForAVailableBookName(){
        assertEquals(2, _biblioteca.findAvailableBooksByTitle("Another awesome book"));
    }

    @Test
    public  void bookShouldBeRemovedFromBookListAfterCheckout() {
        assertEquals(true, _biblioteca.checkoutBook("Another awesome book"));
    }

    @Test
    public void successAfterSuccessfulCheckout(){

        assertEquals(true, _biblioteca.checkoutBook("Another awesome book"));
        assertEquals(false, _biblioteca.checkoutBook("Another awesome book"));
    }

    @Test
    public void unccessfulAfterAnsuccessfulCheckout(){
        _biblioteca.checkoutBook(ItemMocks.WrongBookTitle);

        assertEquals(false, _biblioteca.checkoutBook(ItemMocks.WrongBookTitle));
    }

    @Test
    public void bookShouldBeAddedToBookListAfterReturnBook(){
        Book book = ItemMocks.getBook();

        _biblioteca.checkoutBook(book.getTitle());
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }

    @Test
    public void shouldBeReturnTrueAfterSuccessfulReturnBook(){
        Book book = ItemMocks.getBook();

        assertEquals(true, _biblioteca.checkoutBook(book.getTitle()));
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }

    @Test
    public void unccessfullAfterAnUnsuccessfulReturn(){
        assertEquals(false,  _biblioteca.returnBook(ItemMocks.WrongBookTitle));
    }



    //
    //          MOVIES
    //

    @Test
    public void movieListDetailsShouldPrintedAsColumns() throws FileNotFoundException {
        System.setOut(null);
        String movieDetailsMock = "";
        ArrayList<Movie> movieList = ItemMocks.getMovieList();

        for (Movie movie : movieList){
            movieDetailsMock += movie.getDetails();
        }

        assertEquals(movieDetailsMock, _biblioteca.getMovieListDetails());
    }


    @Test
    public void bibliotecaShouldFindThePositionForAVailableMovieName(){
        assertEquals(1, _biblioteca.findAvailableMoviesByName("The Butterfly Effect"));
    }

    @Test
    public  void movieShouldBeRemovedFromBookListAfterCheckout() {
        assertEquals(true, _biblioteca.checkoutMovie("The Butterfly Effect"));
    }

    @Test
    public void successAfterSuccessfulMovieCheckout(){

        assertEquals(true, _biblioteca.checkoutMovie("The Butterfly Effect"));
        assertEquals(false, _biblioteca.checkoutMovie("The Butterfly Effect"));
    }

    @Test
    public void unccessfulAfterAnsuccessfulMovieCheckout(){
        _biblioteca.checkoutMovie(ItemMocks.WrongMovieName);

        assertEquals(false, _biblioteca.checkoutBook(ItemMocks.WrongMovieName));
    }

    @Test
    public void bookShouldBeAddedToMovieListAfterReturnMovie(){
        Movie movie = ItemMocks.getMovie();

        _biblioteca.checkoutBook(movie.getName());
        assertEquals(true, _biblioteca.returnBook(movie.getName()));
    }

    @Test
    public void shouldBeReturnTrueAfterSuccessfulReturnMovie(){
        Movie movie = ItemMocks.getMovie();

        assertEquals(true, _biblioteca.checkoutMovie(movie.getName()));
        assertEquals(true, _biblioteca.returnMovie(movie.getName()));
    }

    @Test
    public void unccessfullAfterAnUnsuccessfulReturnMovie(){
        assertEquals(false,  _biblioteca.returnMovie(ItemMocks.WrongBookTitle));
    }

}
