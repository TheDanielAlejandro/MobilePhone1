package com.company;

import java.util.ArrayList;

public class MobilePhone {                                                                                              // . Creating a class MobilePhone.

    private ArrayList<Contact> contacts;                                                                                // . Initializing the instance variables, this one is an Arraylist of objects from the class "Contact".


    // CONSTRUCTORS

    public MobilePhone(ArrayList<Contact> contacts) {                                                                   // . Creating 2 constructors, the first with the contacts object as a parameter and the second one without.
        this.contacts = new ArrayList<>();
    }

    public MobilePhone() {
        this.contacts = new ArrayList<>();
    }


    // METHODS

    public Contact createContact(String name, String phoneNumber){                                                      // . Method "createContact" with parameters name and phoneNumber.
        if(contactExist(name)){                                                                                         // . calling the method "contactExist" that is a boolean, to check if the contact we want to create already exist.
            System.out.println("The contact already exists.");                                                          // . If there is already a contact object with the same name, print the string.
            return null;                                                                                                // . Return null, so the method is not going to create anything.
        }else{                                                                                                          // . It there isn't any other contact with the same name.
        Contact newContact = new Contact(name, phoneNumber);                                                            // . Creating a new object Contact.
        return newContact;                                                                                              // . Returning the new contact created.
        }                                                                                                               // . This method creates only the contact, doesn't put it inside the arraylist.
    }


    public void addContact(Contact contact){                                                                            // . Method that Add a contact object inside the arraylist.
        contacts.add(contact);
    }


    public Contact getContact(String name){                                                                             // . Method that retrieves the object contact from the arrayList, passing a String name as a parameter.
        int position = findContactPostion(name);                                                                        // . Creating a variable position to store the position of the object in the arraylist, calling the method findContact and passing the name.
        return contacts.get(position);                                                                                  // . Returns the object contact.
    }


    public void removeContact(String name){                                                                             // . Method that removes the contact from the ArrayList, passing a String name as a parameter
        if(findContactPostion(name) >= 0){                                                                              // . Calling the method "findContactPosition" (line 71) and passing the name, if the value is less than 0 means that there isn't any object with that name.
            contacts.remove(findContactPostion(name));                                                                  // . Removing the object found from the ArrayList.
        }
    }

    public void updateContact(Contact oldContact, Contact newContact){                                                  // . Method that substitute one contact for another, 2 contact objects as a parameters.
        int index = findContactPostion(oldContact.getName());                                                           // . Storing in the variable "index" the position of the contact that we want to substitute,
        if(index >= 0){                                                                                                 
            removeContact(oldContact.getName());
            contacts.add(index,newContact);
            System.out.println("Contact found and replaced.");
        }else{
            System.out.println("Contact to update not found.");
        }

    }

    public boolean contactExist(String name){
       int result = findContactPostion(name);
       if(result < 0){
           return false;
       }
       return true;
    }

    private int findContactPostion(String name){
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getName().equals(name)){
                return i;
            }

        }
        return -1;
    }

    public void printList(){
        if(this.contacts.isEmpty()){
            System.out.println("There are no contacts, yet.");
        }else {

            System.out.println("List of contacts:");
            for (int i = 0; i < this.contacts.size(); i++) {
                System.out.println((i + 1) + "- " + this.contacts.get(i).getName() + " -> " + this.contacts.get(i).getNumber());
            }
        }
    }
}


