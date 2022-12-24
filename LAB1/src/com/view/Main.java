package com.view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("WELCOME TO THE SHOW ROOM!");
            System.out.println("1.Add vehicle");
            System.out.println("2.Update vehicle");
            System.out.println("3.Delete vehicle");
            System.out.println("4.Find vehicle");
            System.out.println("5.Show vehicle list");
            int choice= MainFunctions.inputChoice();
            switch (choice) {
                case 1:
                    MainFunctions.add();
                    System.out.println();
                    break;
                case 2:
                    MainFunctions.findAll();
                    MainFunctions.update();
                    System.out.println();
                    break;
                case 3:
                    MainFunctions.findAll();
                    MainFunctions.delete();
                    System.out.println();
                    break;
                case 4:
                    MainFunctions.find();
                    System.out.println();
                    break;
                case 5:
                    MainFunctions.showAll();
                    System.out.println();
                    break;
                default:
                    MainFunctions.findAll();
                    System.out.println();
            }
        }
    }
}
