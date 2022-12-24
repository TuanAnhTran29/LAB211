package com.view;

public class EmployeeMenu {
    public static void openMenu(){
        while (true){
            System.out.println("Employee Menu");
            System.out.println("1.Search asset by name");
            System.out.println("2.Create new asset");
            System.out.println("3.Borrow asset");
            System.out.println("4.Sign out");
            int choice= MainFunction.inputChoice();
            switch (choice){
                case 1:
                    MainFunction.searchAsset();
                    System.out.println();
                    break;
                case 2:
                    MainFunction.addAsset();
                    System.out.println();
                    break;
                case 3:
                    MainFunction.findAllAsset();
                    MainFunction.borrowAsset();
                    System.out.println();
                    break;
                case 4:
                    MainFunction.signOut();
                    break;
            }
        }

    }
}
