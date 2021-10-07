/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Koby Montenegro
 */

package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class App
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        //List for special characters(IT'S EMPTY)
        ArrayList<Character> specialsList = new ArrayList<Character>();
        String special = "!@#&()–[{}]:;'?/*$^+=<>";

        //Use this to fill up the list
        for(int i=0; i<special.length(); i++)
        {
            specialsList.add(special.charAt(i));
        }

        //List for numbers(IT'S EMPTY)
        ArrayList<Character> numbersList = new ArrayList<Character>();
        String numbs = "0123456789";

        //Use this to fill up the list
        for(int i=0; i<numbs.length(); i++)
        {
            numbersList.add(numbs.charAt(i));
        }

        //List for alphabets(IT'S EMPTY)
        ArrayList<Character> lettersList = new ArrayList<Character>();
        String letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

        //Use this to fill up the list
        for(int i=0; i<letters.length(); i++)
        {
            lettersList.add(letters.charAt(i));
        }

        //User input
        System.out.print("What's the minimum length? ");
        int min = scan.nextInt();

        System.out.print("How many special characters? ");
        int spec = scan.nextInt();

        System.out.print("How many numbers? ");
        int numb = scan.nextInt();

        //Generating the password
        String password = " ";

        //Adding random alphabets
        for(int i = 0; i<min-spec-numb; i++)
        {
            password += lettersList.get(random.nextInt(lettersList.size()));
        }

        //Adding random special characters
        for(int i = 0; i<spec;i++)
        {
            password += specialsList.get(random.nextInt(specialsList.size()));
        }

        //Adding random numbers
        for(int i = 0; i<numb;i++)
        {
            password += numbersList.get(random.nextInt(numbersList.size()));
        }

        //Test line to check placement of characters
        //System.out.print("Password before is " + password + "\n");

        //Shuffling the Password
        char[] passLength = password.toCharArray();

        for(int i = passLength.length - 1; i>0;i--)
        {
            int j = random.nextInt(i+1);
            char temp = passLength[i];
            passLength[i] = passLength[j];
            passLength[j] = temp;
        }

        String truePassword = new String(passLength);

        //Printing password
        System.out.println("Your password is " + truePassword);

        scan.close();
    }
}