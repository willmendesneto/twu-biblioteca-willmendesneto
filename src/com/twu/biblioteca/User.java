package com.twu.biblioteca;

public class User {

    private String _name;
    private String _email;
    private String _phone;

    private String _libraryNumber;
    private String _password;
    public boolean isLogged;

    public User(String name, String email, String phone, String libraryNumber, String password) {
        _name = name;
        _email = email;
        _phone = phone;
        _libraryNumber = libraryNumber;
        _password = password;
        isLogged = false;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

    public String getPhone() {
        return _phone;
    }
    public String getLibraryNumber() {
        return _libraryNumber;
    }

    public String getPassword() {
        return _password;
    }

    public boolean checkCredentials (String libraryNumber, String password) {
        return _libraryNumber.equals(libraryNumber) && _password.equals(password);
    }

    public String getDetails(){

        return  "User Informations:\n\n"+
                "Name:         " + _name +  "\n" +
                "Email:        " + _email + "\n" +
                "Phone number: " + _phone + "\n";

    }

}
