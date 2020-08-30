package com.company;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myPhone = new MobilePhone();
    public static void main(String[] args) {



        turnOnPhone();
        listActions();
        boolean action = false;
        while(!action){
            System.out.println("Select the action. 6) to display the actions available.");
            switch (scanner.nextInt()){
                case 0:
                    System.out.println("Turning off...");
                    System.out.println("Goodbye!");
                    action = true;
                    break;
                case 1:
                    myPhone.printList();
                    break;
                case 2:
                    contactAdd();
                    break;
                case 3:
                    contactUpdate();
                    break;
                case 4:
                    contactRemove();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    listActions();
                    break;

            }
        }
    }


    // METHODS

    public static void turnOnPhone(){
        System.out.println("Turning phone on...");
        System.out.println("Welcome!");
    }

    private static void contactAdd() {
        System.out.println("Insert name of the new contact: ");
        String name = scanner.next();
        System.out.println("insert number of the new contact: ");
        String number = scanner.next();
        if (myPhone.contactExist(name)) {
            System.out.println("The contact name is already used.");
        } else {
            Contact newContact = myPhone.createContact(name, number);
            myPhone.addContact(newContact);
            System.out.println("Contact successfully added.");
        }
    }

    public static void contactUpdate() {
        System.out.println("Insert name contact to search: ");
        String name = scanner.next();
        if (myPhone.contactExist(name)) {
            Contact oldContact = myPhone.getContact(name);
            System.out.println("Insert new name: ");
            String newName = scanner.next();
            System.out.println("Insert new number: ");
            String newNumber = scanner.next();
            Contact newContact = myPhone.createContact(newName, newNumber);
            if(newContact != null){
                myPhone.updateContact(oldContact, newContact);
            }
        } else {
            System.out.println("Contact inserted not found.");
        }
    }

    public static void contactRemove() {
        System.out.println("Insert name contact to remove: ");
        String name = scanner.next();
        if (myPhone.contactExist(name)) {
            myPhone.removeContact(name);
            System.out.println("Contact " + name + " has been deleted.");
        }else{
            System.out.println("The name inserted hasn't been found.");
        }
    }

    public static void searchContact(){
        System.out.println("Insert name of contact to search: ");
        String name = scanner.next();
        if(myPhone.contactExist(name)){
           Contact a =  myPhone.getContact(name);
            System.out.println("Name: " + name + " number: " + a.getNumber());
        }else{
            System.out.println("The name inserted hasn't been found.");
        }

    }


    public static void listActions(){
        System.out.println("0 - To shutdown.");
        System.out.println("1 - Print list of contacts.");
        System.out.println("2 - Add a new contact.");
        System.out.println("3 - Update existing contact.");
        System.out.println("4 - Remove contact.");
        System.out.println("5 - Search a contact.");
        System.out.println("6 - Print list of available actions.");
        System.out.println("Choose your action: ");
    }


}
