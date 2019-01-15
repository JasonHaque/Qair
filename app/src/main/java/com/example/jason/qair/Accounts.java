package com.example.jason.qair;

public class Accounts {
    public String Email;
    public String Occupation;

    public Accounts(){

    }

    public Accounts(String email, String occupation) {
        Email = email;
        Occupation = occupation;
    }

    public String getEmail() {
        return Email;
    }

    public String getOccupation() {
        return Occupation;
    }
}
