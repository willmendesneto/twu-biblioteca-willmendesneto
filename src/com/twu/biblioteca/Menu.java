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
        }});
    }

    public String readBookName(){
        Scanner text = new Scanner(System.in);
        System.out.println(MessagesHelper.SearchBookInLibrary);
        String bookTitle = text.nextLine();
        return bookTitle;
    }

    public void menuOptions(int option) {
        String message = "";
        switch (option) {
            case 1:
                message += _biblioteca.getBookListDetails();
                break;
            case 2:
                boolean checkoutWithSuccess = _biblioteca.checkout(readBookName());
                message += (checkoutWithSuccess == true) ?
                        MessagesHelper.CheckoutSuccess :
                        MessagesHelper.CheckoutError;
                break;
            case 3:
                boolean bookWasReturnedWithSuccess = _biblioteca.returnBook(readBookName());
                message += (bookWasReturnedWithSuccess) ?
                        MessagesHelper.ReturnBookSuccess :
                        MessagesHelper.ReturnBookError;
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
