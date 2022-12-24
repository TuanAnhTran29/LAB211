package com.view;

public class ManagerMenu {
    public static void openMenu(){
        while (true){
            System.out.println("Manager Menu");
            System.out.println("1.Search asset by name");
            System.out.println("2.Create new asset");
            System.out.println("3.Update asset");
            System.out.println("4.Approve request");
            System.out.println("5.Borrow list");
            System.out.println("6.Sign out");
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
                    MainFunction.updateAsset();
                    System.out.println();
                    break;
                case 4:
                    MainFunction.findAllRequest();
                    MainFunction.approve();
                    System.out.println();
                    break;
                case 5:
                    MainFunction.findAllBorrow();
                    System.out.println();
                    break;
                case 6:
                    MainFunction.signOut();
                    break;
            }
        }

    }
}
