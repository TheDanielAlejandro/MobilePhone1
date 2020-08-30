package com.company;

public class Contact {                                                                                                  // . Creating a class Contact.

    private String name;                                                                                                // . Initializing the instance variables.
    private String number;


    // CONSTRUCTOR

    public Contact(String name, String number) {                                                                        // . Creating the constructor.
        this.name = name;
        this.number = number;
    }


    // GET METHODS

    public String getName() {                                                                                           // . Get method, for the name Instance.
        return name;
    }

    public String getNumber() {                                                                                         // . Get method, for the number Instance.
        return number;
    }
}