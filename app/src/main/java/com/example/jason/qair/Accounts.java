package com.example.jason.qair;

public class Accounts {
    public String email;
    public String occupation;

    public Accounts(){

    }

    public Accounts(String eemail, String ooccupation) {
        email = eemail;
        occupation = ooccupation;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }
}
