package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Biblioteca _biblioteca;

    private User currentUser;

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
        }});
    }

    public String readInputInformation(String message){
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

                if (!hasUserLogged()) {
                    userLogin(MessagesHelper.LoginIsRequired);
                } else {
                    boolean checkoutBookWithSuccess = _biblioteca.checkoutBook(readInputInformation(MessagesHelper.SearchBookInLibrary), currentUser.getLibraryNumber());
                    message += (checkoutBookWithSuccess == true) ?
                            MessagesHelper.CheckoutBookSuccess :
                            MessagesHelper.CheckoutBookError;
                }

                break;
            case 3:

                if (!hasUserLogged()) {
                    userLogin(MessagesHelper.LoginIsRequired);
                } else {
                    boolean bookWasReturnedWithSuccess = _biblioteca.returnBook(readInputInformation(MessagesHelper.SearchBookInLibrary));
                    message += (bookWasReturnedWithSuccess) ?
                            MessagesHelper.ReturnBookSuccess :
                            MessagesHelper.ReturnBookError;
                }
                break;
            case 4:
                message += _biblioteca.getMovieListDetails();
                break;
            case 5:

                if (!hasUserLogged()) {
                    userLogin(MessagesHelper.LoginIsRequired);
                } else {
                    boolean checkoutMovieWithSuccess = _biblioteca.checkoutMovie(readInputInformation(MessagesHelper.SearchMovieInLibrary), currentUser.getLibraryNumber());
                    message += (checkoutMovieWithSuccess == true) ?
                            MessagesHelper.CheckoutMovieSuccess :
                            MessagesHelper.CheckoutMovieError;
                }
                break;
            case 6:

                if (!hasUserLogged()) {
                    userLogin(MessagesHelper.LoginIsRequired);
                } else {
                    boolean movieWasReturnedWithSuccess = _biblioteca.returnMovie(readInputInformation(MessagesHelper.SearchMovieInLibrary));
                    message += (movieWasReturnedWithSuccess) ?
                            MessagesHelper.ReturnMovieSuccess :
                            MessagesHelper.ReturnMovieError;
                }
                break;
            case 7:
                userLogin(MessagesHelper.LoginIsRequired);
                break;

            case 8:

                if (!hasUserLogged()) {
                    userLogin(MessagesHelper.LoginIsRequired);
                } else {
                    message += _biblioteca.getUserLoggedDetails();
                }
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

    public boolean hasUserLogged () {
        return currentUser != null && currentUser.isLogged == true;
    }

    public void userLogin(String message) {
        System.out.println(message);
        String libraryNumber = readInputInformation(MessagesHelper.LibraryNumber);
        String password = readInputInformation(MessagesHelper.Password);
        boolean userIsLogged = _biblioteca.login(libraryNumber, password);

        if (userIsLogged){
            currentUser = _biblioteca.getUserLogged();
            message = String.format(MessagesHelper.LoginUserSuccess, currentUser.getName());
        }else{
            message = MessagesHelper.LoginUserError;
        }

        System.out.println(message);
    }
}
