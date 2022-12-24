package com.view;

import com.controller.AssetController;
import com.controller.BorrowController;
import com.controller.EmployeeController;
import com.controller.RequestController;
import com.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainFunction {
    private static Scanner scanner= new Scanner(System.in);

    private static EmployeeController employeeController= new EmployeeController();
    private static AssetController assetController= new AssetController();
    private static RequestController requestController= new RequestController();
    private static BorrowController borrowController= new BorrowController();

    private static Employee currentUser= null;


    //LOGIN, REGISTER
    public static void loginMenu(){
        System.out.println("WELCOME");
        System.out.println("Please login to use our service");
        System.out.println("(If you do not have account, please register)");
        boolean finish= false;
        while (!finish){
            System.out.println("1.Sign In");
            System.out.println("2.Register");
            int choice= MainFunction.inputChoice();
            switch (choice){
                case 1:
                    boolean loggedIn= false;
                    while (!loggedIn){
                        System.out.println("LOG IN");
                        System.out.print("Employee ID: ");
                        String employeeId= scanner.nextLine();
                        System.out.print("Password: ");
                        String password= scanner.nextLine();
                        currentUser= employeeController.login(employeeId,Base64.getEncoder().encodeToString(password.getBytes()));
                            if (currentUser!= null){
                                loggedIn= true;
                                if (currentUser.getRole().equals(Role.EM)){
                                    EmployeeMenu.openMenu();
                                    finish= true;
                                }else {
                                    ManagerMenu.openMenu();
                                    finish= true;
                                }
                            }else {
                                System.out.println("Login fail!");
                                System.out.println("Your ID or password is wrong");
                            }
                    }
                    break;
                case 2:
                    Employee employee= new Employee();
                    System.out.println("REGISTER");

                    System.out.print("Enter ID: ");
                    String id= MainFunction.input();
                    while (employeeController.findById(id)!= null){
                        System.out.println("Account existed!");
                        System.out.print("Re-enter ID: ");
                        id= MainFunction.input();
                    }
                    System.out.print("Enter name: ");
                    String name= MainFunction.input();
                    System.out.print("Enter birthday: ");
                    String birthday= MainFunction.inputBirthday();
                    System.out.println("Enter role (1.EM/2.MA)");
                    int option= MainFunction.inputChoice();
                    boolean next= true;
                    while (next){
                        switch (option){
                            case 1:
                                Role EMRole= Role.EM;
                                employee.setRole(EMRole);
                                next= false;
                                break;
                            case 2:
                                Role MARole= Role.MA;
                                employee.setRole(MARole);
                                next= false;
                                break;
                            default:
                                System.out.println("Role must be in range 1-2");
                        }

                    }
                    next= true;
                    System.out.println("Enter sex (1.FEMALE/2.MALE)");
                    option= MainFunction.inputChoice();
                    while (next){
                        switch (option){
                            case 1:
                                Sex female= Sex.FEMALE;
                                employee.setSex(female);
                                next= false;
                                break;
                            case 2:
                                Sex male= Sex.MALE;
                                employee.setSex(male);
                                next= false;
                                break;
                            default:
                                System.out.println("Sex must be in range 1-2");

                        }
                    }
                    System.out.print("Enter password: ");
                    String password= MainFunction.input();
                    while (password.length() < 8){
                        System.out.println("Password must be longer than 8 characters");
                        System.out.print("Re-enter password: ");
                        password= MainFunction.input();
                    }
                    employee.setEmployeeID(id);
                    employee.setName(name);
                    employee.setBirthday(birthday);
                    employee.setPassword(password);

                    employeeController.signup(employee);
                    System.out.println("Registered success");
                    System.out.println();
                    break;
            }
        }
    }
    //LOGIN, REGISTER


    // INPUT DATA
    public static int inputChoice(){
        System.out.print("Enter your choice: ");
        String choice= scanner.nextLine();
        while (choice.isEmpty() || choice.matches("[\\s]")){
            System.out.println("Choice can not be blank!");
            System.out.print("Enter your choice: ");
            choice= scanner.nextLine();
        }
        while (checkInput(choice)) {
            System.out.println("Choice must be digital!");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        }
        return Integer.parseInt(choice);
    }

    public static String inputWeight(){
        String input= scanner.nextLine();
        while (input.isEmpty() || input.matches("[\\s]")){
            System.out.println("Weight can not be blank!");
            System.out.print("Re-enter weight: ");
            input= scanner.nextLine();
        }
        while (checkInput(input)) {
            System.out.println("Weight must be digital!");
            System.out.print("Re-enter weight: ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static int inputPrice(){
        String input= scanner.nextLine();
        while (input.isEmpty() || input.matches("[\\s]")){
            System.out.println("Price can not be blank!");
            System.out.print("Re-enter price: ");
            input= scanner.nextLine();
        }
        while (checkInput(input)) {
            System.out.println("Price must be digital!");
            System.out.print("Re-enter price: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    public static int inputQuantity(){
        String input= scanner.nextLine();
        while (input.isEmpty() || input.matches("[\\s]")){
            System.out.println("Quantity can not be blank!");
            System.out.print("Re-enter quantity: ");
            input= scanner.nextLine();
        }
        while (checkInput(input)) {
            System.out.println("Quantity must be digital!");
            System.out.print("Re-enter quantity: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }


    public static String input(){
        String input= scanner.nextLine();
        while (input.isEmpty() || input.matches("[\\s]")){
            System.out.println("Input can not be blank!");
            System.out.print("Re-enter input: ");
            input= scanner.nextLine();
        }
        while (!checkInput(input)) {
            System.out.println("Input must be word!");
            System.out.print("Re-enter input: ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static int inputID(){
        String id= scanner.nextLine();
        while (id.isEmpty() || id.matches("[\\s]")){
            System.out.println("ID can not be blank!");
            System.out.print("Re-enter ID: ");
            id= scanner.nextLine();
        }
        while (checkInput(id)) {
            System.out.println("ID must be digital!");
            System.out.print("Re-enter ID: ");
            id = scanner.nextLine();
        }
        return Integer.parseInt(id);
    }


    public static String inputBirthday(){
        String birthday= scanner.nextLine();
        while (birthday.isEmpty() || birthday.matches("[\\s]")){
            System.out.println("Birthday can not be blank!");
            System.out.print("Re-enter birthday: ");
            birthday= scanner.nextLine();
        }
        while (!birthday.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
            System.out.println("Birthday must be in form dd/MM/yyyy");
            System.out.print("Re-enter birthday: ");
            birthday= scanner.nextLine();
        }
        return birthday;
    }
    //INPUT DATA







    //MAIN FUNCTIONS
    public static void addAsset() {
        boolean next= true;
        while (next){
            System.out.println("Create Asset Form");
            System.out.print("Enter asset ID: ");
            String assetID= input();
            while (assetController.findById(assetID)!= null){
                System.out.println("Existed asset");
                System.out.print("Re-enter asset ID: ");
                assetID= input();
            }
            System.out.print("Enter asset name: ");
            String name= input();
            System.out.print("Enter asset color: ");
            String color= input();
            System.out.print("Enter asset price: ");
            int price= inputPrice();
            System.out.print("Enter asset weight: ");
            String weight= inputWeight();
            System.out.print("Enter asset quantity: ");
            int quantity= inputQuantity();

            Asset asset= new Asset(assetID,name,color,price,weight,quantity);
            assetController.add(asset);
            System.out.println("Created asset successfully!");

            System.out.println("Do you want to add more?");
            System.out.println("Yes/No (Y/N)");
            String choice= scanner.nextLine();
            next= choice.equals("Y") || choice.equals("y");
        }

    }

    public static void searchAsset(){
        System.out.println("Search Asset");
        System.out.print("Enter asset name: ");
        String name= input();
        while (assetController.findByName(name).isEmpty()){
            System.out.println("Asset name " + name + " does not exist!");
            System.out.print("Re-enter asset name: ");
            name= input();
        }
        List<Asset> assets = new ArrayList<>(assetController.findByName(name));
        assets.sort((o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
        System.out.println("Asset List (Descending by price)");
        for (Asset asset : assets) {
            System.out.println(asset);
        }
    }

    public static void updateAsset(){
        System.out.print("Enter asset ID: ");
        String id= input();
        Asset asset= assetController.findById(id);
        if (asset!= null){
            System.out.print("Enter new asset ID: ");
            String newID= scanner.nextLine();
            if (newID.isEmpty() || newID.matches("[\\s]")){
                newID= asset.getAssetsID();
            }
            while (!checkInput(newID)){
                System.out.println("ID must be word");
                System.out.print("Re-enter ID: ");
                newID= scanner.nextLine();
            }
            System.out.print("Enter new asset name: ");
            String newName= scanner.nextLine();
            if (newName.isEmpty() || newName.matches("[\\s]")){
                newName= asset.getName();
            }
            while (!checkInput(newName)){
                System.out.println("Name must be word");
                System.out.print("Re-enter name: ");
                newName= scanner.nextLine();
            }
            System.out.print("Enter new asset color: ");
            String newColor= scanner.nextLine();
            if (newColor.isEmpty() || newColor.matches("[\\s]")){
                newColor= asset.getColor();
            }
            while (!checkInput(newColor)){
                System.out.println("Color must be word");
                System.out.print("Re-enter color: ");
                newColor= scanner.nextLine();
            }
            System.out.print("Enter new price: ");
            String newPrice= scanner.nextLine();
            if (newPrice.isEmpty() || newPrice.matches("[\\s]")){
                newPrice= String.valueOf(asset.getPrice());
            }
            while (checkInput(newPrice)){
                System.out.println("Price must be digital");
                System.out.print("Re-enter price: ");
                newPrice= scanner.nextLine();
            }
            System.out.print("Enter new weight: ");
            String newWeight= scanner.nextLine();
            if (newWeight.isEmpty() || newWeight.matches("[\\s]")){
                newWeight= String.valueOf(asset.getPrice());
            }
            while (checkInput(newWeight)){
                System.out.println("Weight must be digital");
                System.out.print("Re-enter weight: ");
                newWeight= scanner.nextLine();
            }
            System.out.print("Enter new quantity: ");
            String newQuantity= scanner.nextLine();
            if (newQuantity.isEmpty() || newQuantity.matches("[\\s]")){
                newQuantity= String.valueOf(asset.getQuantity());
            }
            while (checkInput(newQuantity)){
                System.out.println("Quantity must be digital");
                System.out.print("Re-enter quantity: ");
                newQuantity= scanner.nextLine();
            }


            asset.setAssetsID(newID);
            asset.setAssetsID(newName);
            asset.setAssetsID(newColor);
            asset.setColor(newColor);
            asset.setPrice(Integer.parseInt(newPrice));
            asset.setWeight(newWeight);
            asset.setQuantity(Integer.parseInt(newQuantity));

            assetController.update(asset);
            System.out.println("Updated successfully!");
        }else {
            System.out.println("Asset does not exist");
        }
    }

    public static void findAllRequest(){
        System.out.println("Request List");
        for (Request a: requestController.findAll()) {
            System.out.println(a);
        }
    }

    public static void findAllAsset(){
        System.out.println("Asset List");
        for (Asset a: assetController.findAll()){
            System.out.println(a);
        }
    }

    public static void borrowAsset() {
        System.out.print("Enter asset ID to borrow: ");
        String aID= input();
        Asset asset= assetController.findById(aID);
        if (asset== null){
            System.out.println("Asset does not exist");
        }else {
            System.out.print("Enter asset quantity to borrow: ");
            int quantity= inputQuantity();

            //GET CURRENT DATE AND TIME
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime localDateTime= LocalDateTime.now();
            String dateTime= dateTimeFormatter.format(localDateTime);
            //GET CURRENT DATE AND TIME

            int rID;
            if (requestController.findAll().isEmpty()){
                rID= 1;
            }else {
                rID= requestController.findAll().get(requestController.findAll().size()-1).getrID() + 1;
            }

            Request request= new Request(rID,asset.getAssetsID(),currentUser,quantity,dateTime);
            requestController.add(request);
            System.out.println("Requested success");
        }
    }

    public static void approve() {
        System.out.println("Do you want to approve or cancel request? (1.Approve/2.Cancel)");
        int option= inputChoice();
        if (option != 1){
            System.out.print("Enter request ID to cancel: ");
            int rID= inputID();
            Request request = requestController.findByID(rID);
            if (request == null){
                System.out.println("Request does not exist");
            }else {
                System.out.print("Do you want to cancel this request? Y/N");
                String choice= scanner.nextLine();
                while (choice.isEmpty() || choice.matches("[\\s]")){
                    System.out.println("Choice can not be blank!");
                    System.out.print("Re-enter choice: ");
                    choice= scanner.nextLine();
                }
                while (!checkInput(choice)) {
                    System.out.println("Choice must be word!");
                    System.out.print("Re-enter choice: ");
                    choice = scanner.nextLine();
                }
                if (choice.equals("Y") || choice.equals("y")){
                    requestController.delete(request);
                    System.out.println("Canceled request successfully");
                }else {
                    System.out.println("Cancel request fail");
                }

            }
        }else {
            System.out.print("Enter request ID to approve: ");
            int rID= inputID();
            Request request= requestController.findByID(rID);
            if (request == null){
                System.out.println("Request does not exist");
            }else {
                Asset asset= assetController.findById(request.getAssestID());

                if (asset == null || request.getQuantity() > asset.getQuantity()){
                    requestController.delete(request);
                    System.out.println("This asset does not have enough in stock to borrow");
                }else {

                    int bID;
                    if (borrowController.findAll().isEmpty()){
                        bID= 1;
                    }else {
                        bID= borrowController.findAll().get(borrowController.findAll().size()-1).getbID() + 1;
                    }

                    //GET CURRENT DATE AND TIME
                    DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime localDateTime= LocalDateTime.now();
                    String dateTime= dateTimeFormatter.format(localDateTime);
                    //GET CURRENT DATE AND TIME

                    Borrow borrow= new Borrow(bID,asset.getAssetsID(),currentUser,request.getQuantity(),dateTime);

                    if (request.getQuantity() == asset.getQuantity()){
                        assetController.delete(asset);
                    }else {
                        asset.setQuantity(asset.getQuantity() - request.getQuantity());
                        assetController.update(asset);
                    }

                    requestController.delete(request);
                    borrowController.add(borrow);

                    System.out.println("Request approved");
                }

            }
        }

    }

    public static void findAllBorrow(){
        System.out.println("Borrow List");
        for (Borrow b: borrowController.findAll()) {
            System.out.println(b);
        }
    }

    public static void signOut() {
        currentUser= null;
        loginMenu();
    }
    //MAIN FUNCTIONS

















    //VALIDATE INPUT
    public static boolean checkInput(String string) {
        return string.matches("[a-zA-Z]+")
                || string.matches("[a-zA-Z]+[0-9]+")
                || string.matches("[0-9]+[a-zA-Z]+")
                || string.matches("[0-9]+[a-zA-Z]+[0-9]+");
    }
    //VALIDATE INPUT
}
