package com.view;

import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1.Create");
            System.out.println("2.Find and Sort");
            System.out.println("3.Update/Delete");
            System.out.println("4.Report");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            String choice= scanner.nextLine();
            while (choice.isEmpty() || choice.matches("\\s+")){
                System.out.println("Choice can not be blank");
                System.out.print("Re-enter choice: ");
                choice= scanner.nextLine();
            }
            switch (Integer.parseInt(choice)){
                case 1:
                    MainFunction.create();
                    System.out.println();
                    break;
                case 2:
                    MainFunction.findAndSort();
                    System.out.println();
                    break;
                case 3:
                    MainFunction.updateAndDelete();
                    System.out.println();
                    break;
                case 4:
                    MainFunction.report();
                    System.out.println();
                    break;
                default:
                    System.out.println("BYE");
                    System.exit(0);
            }
        }

    }
}
