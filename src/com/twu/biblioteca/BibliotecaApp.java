package com.twu.biblioteca;

public class BibliotecaApp {


    public static void welcomeMessage(){
        System.out.println(MessagesHelper.Welcome);
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcomeMessage();
        bibliotecaApp.initMenu();

    }

    public void initMenu() {
        Menu menu = new Menu();
        menu.init();
    }

}
