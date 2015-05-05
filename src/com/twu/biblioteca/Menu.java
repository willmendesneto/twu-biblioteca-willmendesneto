package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Biblioteca _biblioteca;

    public Menu() {
        _biblioteca = new Biblioteca(new ArrayList<Book>() {{
            add(new Book("Learning TDD", "Cool Girl", 2015));
            add(new Book("Awesome book", "author with huge name", 2014));
            add(new Book("Another awesome book", "myself", 2013));
        }},
        new ArrayList<Movie>() {{
            add(new Movie("Jurassic Park", "Spielberg", 2008, 9));
            add(new Movie("The Butterfly Effect", "Eric Bress", 2004, 7));
            add(new Movie("Saw", "James Wan", 2005, 10));
        }}
        );
    }

    public String readItemInformation(String message){
        Scanner text = new Scanner(System.in);
        System.out.println(message);
        String itemInformation = text.nextLine();
        return itemInformation;
    }

    public void menuOptions(int option) {
        String message = "";
        switch (option) {
            case 1:
                message += _biblioteca.getBookListDetails();
                break;
            case 2:
                boolean checkoutBookWithSuccess = _biblioteca.checkoutBook(readItemInformation(MessagesHelper.SearchBookInLibrary));
                message += (checkoutBookWithSuccess == true) ?
                        MessagesHelper.CheckoutBookSuccess :
                        MessagesHelper.CheckoutBookError;
                break;
            case 3:
                boolean bookWasReturnedWithSuccess = _biblioteca.returnBook(readItemInformation(MessagesHelper.SearchBookInLibrary));
                message += (bookWasReturnedWithSuccess) ?
                        MessagesHelper.ReturnBookSuccess :
                        MessagesHelper.ReturnBookError;
                break;
            case 4:
                message += _biblioteca.getMovieListDetails();
                break;
            case 5:
                boolean checkoutMovieWithSuccess = _biblioteca.checkoutMovie(readItemInformation(MessagesHelper.SearchMovieInLibrary));
                message += (checkoutMovieWithSuccess == true) ?
                        MessagesHelper.CheckoutMovieSuccess :
                        MessagesHelper.CheckoutMovieError;
                break;
            case 6:
                boolean movieWasReturnedWithSuccess = _biblioteca.returnMovie(readItemInformation(MessagesHelper.SearchMovieInLibrary));
                message += (movieWasReturnedWithSuccess) ?
                        MessagesHelper.ReturnMovieSuccess :
                        MessagesHelper.ReturnMovieError;
                break;
            case 0:
                message += MessagesHelper.Quit;
                break;
            default:
                message += MessagesHelper.OptionIsInvalid;
        }
        System.out.println(message);

        if (option == 0) {
            System.exit(1);
        }
    }

    public void printMenu(){
        System.out.println(MessagesHelper.MenuOptions);
    }

    public void init(){
        Scanner in = new Scanner(System.in);
        int option = 0;
        printMenu();

        while (true){
            try {
                option = in.nextInt();
                menuOptions(option);
                printMenu();
            }catch (Exception e){
                System.out.println(MessagesHelper.OptionIsInvalid);
                init();
            }

        }
    }
}
