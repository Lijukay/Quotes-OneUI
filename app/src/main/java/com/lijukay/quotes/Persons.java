package com.lijukay.quotes;


public class Persons {
    //Code by Yanndroid
    private String personsName;
    public boolean isSeparator;

    public String getPersonsName() {
        return personsName;
    }

    public void setPersonsName(String personsName, String tag) {
        this.personsName = personsName;

    }

    public Persons(String personsName) {
        this(personsName, false);
    }

    public Persons(String personsName, boolean isSeparator) {
        this.personsName = personsName;
        this.isSeparator = isSeparator;
    }
}