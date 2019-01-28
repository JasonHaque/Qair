package com.example.jason.qair;
public class Question {
    private String questiontext,optiona,optionb,optionc,optiond,correctoption;
    private String id;

    public Question(){

    }

    public Question(String questiontext, String optiona, String optionb, String optionc, String optiond, String correctoption) {
        this.questiontext = questiontext;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.correctoption = correctoption;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public String getOptiona() {
        return optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public String getCorrectoption() {
        return correctoption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

