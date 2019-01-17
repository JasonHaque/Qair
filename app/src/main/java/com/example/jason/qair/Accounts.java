package com.example.jason.qair;

public class Accounts {


    public String email;
    public String occupation;
    public String id;


    public Accounts(){

    }

    public Accounts(String email, String occupation,String id) {
        email = email;
        occupation = occupation;
        id=id;

    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }
}
