package com.view;

import com.controller.VehicleController;
import com.model.Car;
import com.model.Motorbike;
import com.model.Vehicle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainFunctions {
    private static VehicleController vehicleController= new VehicleController();
//    private static CarController carController = new CarController();
//    private static MotorbikeController motorbikeController= new MotorbikeController();

    private static Scanner scanner = new Scanner(System.in);


    // Main functions

    // Add Car
    public static void add() {
        boolean next= true;

        while (next){
            System.out.println("1.Add car");
            System.out.println("2.Add motorbike");
            System.out.println("0.Back to main menu");
            int choice1= inputChoice();
            Long id;
            if (vehicleController.findAll().isEmpty()){
                id= 1L;
            }else {
                id= vehicleController.findAll().get(vehicleController.findAll().size()-1).getId() + 1;
            }
            switch (choice1){
                case 1:
                    System.out.println("ADD CAR FORM");
                    String carName = inputName();
                    String carColor = inputColor();
                    int carPrice = inputPrice();
                    String carBrand = inputBrand();
                    String carType = inputType();
                    int carYom = inputYOM();

                    Car car = new Car(id, carName, carColor,carPrice, carBrand, carType,carYom);

//                    carController.add(car);
                    vehicleController.add(car);
                    System.out.println("Added successfully!");
                    break;
                case 2:
                    System.out.println("ADD MOTORBIKE FORM");
                    String motorName = inputName();
                    String motorColor = inputColor();
                    int motorPrice = inputPrice();
                    String motorBrand = inputBrand();
                    int motorSpeed = inputSpeed();
                    String motorLicense = inputLicense();

                    Motorbike motorbike = new Motorbike(id,motorName, motorColor,motorPrice, motorBrand, motorSpeed,motorLicense);

//                    motorbikeController.add(motorbike);
                    vehicleController.add(motorbike);
                    System.out.println("Added successfully!");
                    break;

            }


            System.out.println("Do you want to add more? Y/N");
            String choice= scanner.nextLine();
            if (choice.equals("Y") || choice.equals("y")){
                next= true;
            }else {
                next= false;
            }
        }

    }



    // Print All Car
    public static void findAll() {
        if (vehicleController.findAll().isEmpty()){
            System.out.println("There are no vehicles in the list!");
        }else {
            System.out.println("Vehicle List");
            for (int i = 0; i < vehicleController.findAll().size(); i++) {
                System.out.println(vehicleController.findAll().get(i));
            }
        }

    }

    // Update Car
    public static void update(){
        if (vehicleController.findAll().isEmpty()){
            System.out.println("There are no vehicles to update!");
        }else {
            System.out.println("1.Update Vehicle");
            System.out.println("0.Exit to main menu");
            int choice= inputChoice();
            if (choice == 1){
                Long id= inputID();
                while (findById(id) == null){
                    System.out.println("Vehicle does not exist!");
                    System.out.print("Re-enter ID: ");
                    id= inputID();
                }
                Vehicle oldVehicle= findById(id);
                System.out.print("Enter new name: ");
                String newVehicleName= scanner.nextLine();
                if (newVehicleName.isEmpty() || newVehicleName.matches("[\\s]")){
                    newVehicleName= oldVehicle.getName();
                }
                System.out.print("Enter new color: ");
                String newVehicleColor= scanner.nextLine();
                if (newVehicleColor.isEmpty() || newVehicleColor.matches("[\\s]")){
                    newVehicleColor= oldVehicle.getColor();
                }
                System.out.print("Enter new price: ");
                int newVehiclePrice= inputPrice2(oldVehicle);
                System.out.print("Enter new brand: ");
                String newVehicleBrand= scanner.nextLine();
                if (newVehicleBrand.isEmpty() || newVehicleBrand.matches("[\\s]")){
                    newVehicleBrand= oldVehicle.getBrand();
                }

                oldVehicle.setName(newVehicleName);
                oldVehicle.setColor(newVehicleColor);
                oldVehicle.setPrice(newVehiclePrice);
                oldVehicle.setBrand(newVehicleBrand);

                vehicleController.update(oldVehicle);
                System.out.println("Updated successfully!");


            }


        }

    }

    //Delete Car
    public static void delete(){
        if (vehicleController.findAll().isEmpty()){
            System.out.println("There are no vehicles to delete");
        }else {
            System.out.print("Enter vehicles ID to delete: ");
            Long id= inputID();
            Vehicle vehicle= findById(id);
            if (vehicle!= null){
                System.out.println("Do you want to delete this vehicles? Y/N");
                String choice= scanner.nextLine();
                if (choice.equals("Y") || choice.equals("y")){
                    vehicleController.delete(vehicle);
                    System.out.println("Deleted successfully!");
                }else {
                    System.out.println("Delete fail!");
                }

            }
        }
    }

    public static void find() {
        System.out.println("1.Find by ID");
        System.out.println("2.Find by Name");
        System.out.println("0.Exit to main menu");
        int choice= inputChoice();
        while (choice >= 1 && choice<= 2){
            switch (choice){
                case 1:
                    Long id= inputID();
                    if (findById(id) == null){
                        System.out.println("Can not find this vehicle!");
                    }else {
                        System.out.println(findById(id));
                    }

                    break;
                case 2:
                    String name= inputName();
                    if (findByName(name).isEmpty()){
                        System.out.println("Can not find this vehicle!");
                    }else {
                        findAllVehicle(findByName(name));
                    }
                    break;


            }
            System.out.println("1.Find by ID");
            System.out.println("2.Find by Name");
            System.out.println("0.Exit to main menu");
            choice= inputChoice();
        }

    }


    public static void showAll() {
        System.out.println("1.Show all");
        System.out.println("2.Show descending by price");
        System.out.println("0.Exit to main menu");
        int choice= inputChoice();
        while (choice >=1 && choice<= 2){
            switch (choice){
                case 1:
                    findAll();
                    break;
                case 2:
                    List<Vehicle> vehicleList= vehicleController.findAll();
                    Collections.sort(vehicleList, new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            if (o1.getPrice() < o2.getPrice()){
                                return 1;
                            }else if (o1.getPrice() == o2.getPrice()){
                                return 0;
                            }else {
                                return -1;
                            }
                        }
                    });
                    findAllVehicle(vehicleList);
                    break;
            }
            System.out.println("1.Show all");
            System.out.println("2.Show descending by price");
            System.out.println("0.Exit to main menu");
            choice= inputChoice();
        }

    }
    // Main functions



    // Find Vehicle By ID
    public static Vehicle findById(Long id){
        return vehicleController.findById(id);
    }
    // Find Vehicle By Name
    public static List<Vehicle> findByName(String name){
        return vehicleController.findByName(name);
    }
    // Find All Vehicles
    public static void findAllVehicle(List<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }
    }



    // Input Data
    public static Long inputID(){
        System.out.print("Enter ID: ");
        String id= scanner.nextLine();
        while (checkInput(id)){
            System.out.println("ID must be digital!");
            System.out.print("Re-enter ID: ");
            id= scanner.nextLine();
        }
        while (id.isEmpty() || id.matches("[\\s]")){
            System.out.println("ID can not be blank!");
            System.out.print("Re-enter ID: ");
            id= scanner.nextLine();
        }

        return Long.parseLong(id);
    }
    public static String inputColor(){
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        while (!checkInput(color)){
            System.out.println("Color must be word!");
            System.out.print("Re-enter color: ");
            color= scanner.nextLine();
        }
        while (color.matches("[\\s]") || color.isEmpty()){
            System.out.println("Color can not be blank!");
            System.out.print("Re-enter color: ");
            color= scanner.nextLine();
        }
        return color;
    }

    public static int inputPrice(){
        System.out.print("Enter price: ");
        String price = scanner.nextLine();
        while (checkInput(price)){
            System.out.println("Price must be digital!");
            System.out.print("Re-enter price: ");
            price= scanner.nextLine();
        }
        while (price.isEmpty() || price.matches("[\\s]")){
            System.out.println("Price can not be blank!");
            System.out.print("Re-enter price: ");
            price= scanner.nextLine();
        }
        return Integer.parseInt(price);
    }

    public static String inputType(){
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        while (!checkInput(type)){
            System.out.println("Type must be word!");
            System.out.print("Re-enter type: ");
            type= scanner.nextLine();
        }
        while (type.isEmpty() || type.matches("[\\s]")){
            System.out.println("Type can not be blank!");
            System.out.print("Re-enter type: ");
            type= scanner.nextLine();
        }
        return type;
    }

    public static int inputYOM(){
        System.out.print("Enter year of manufacture: ");
        String yom = scanner.nextLine();
        while (checkInput(yom)){
            System.out.println("Year of manufacture must be digital!");
            System.out.print("Re-enter year of manufacture: ");
            yom= scanner.nextLine();
        }
        while (yom.isEmpty() || yom.matches("[\\s]")){
            System.out.println("Year of manufacture can not be blank!");
            System.out.print("Re-enter year of manufacture: ");
            yom= scanner.nextLine();
        }
        return Integer.parseInt(yom);
    }

    public static String inputName(){
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        while (name.matches("[\\s]") || name.isEmpty()){
            System.out.println("Name can not be blank!");
            System.out.print("Re-enter name: ");
            name = scanner.nextLine();
        }
        return name;
    }

    public static String inputBrand(){
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        if (brand.matches("[\\s]") || brand.isEmpty()){
            System.out.println("Brand can not be blank!");
            System.out.print("Re-enter name: ");
            brand = scanner.nextLine();
        }
        return brand;
    }

    public static int inputChoice(){
        System.out.print("Enter your choice: ");
        String choice= scanner.nextLine();
        while (choice.isEmpty() || choice.matches("[\\s]")){
            System.out.println("Choice can not be blank!");
            System.out.print("Enter your choice: ");
            choice= scanner.nextLine();
        }
        while (MainFunctions.checkInput(choice)) {
            System.out.println("Choice must be digital!");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        }
        return Integer.parseInt(choice);
    }

    public static int inputSpeed() {
        System.out.print("Enter speed (km/h): ");
        String speed= scanner.nextLine();
        while (speed.isEmpty() || speed.matches("[\\s]")){
            System.out.println("Speed can not be blank!");
            System.out.print("Re-enter speed (km/h): ");
            speed= scanner.nextLine();
        }
        while (MainFunctions.checkInput(speed)) {
            System.out.println("Speed must be digital!");
            System.out.print("Re-enter speed (km/h): ");
            speed = scanner.nextLine();
        }
        return Integer.parseInt(speed);
    }

    public static String inputLicense(){
        System.out.print("Enter license: ");
        String license= scanner.nextLine();
        while (license.isEmpty() || license.matches("[\\s]")){
            System.out.println("License can not be blank!");
            System.out.print("Re-enter license: ");
            license= scanner.nextLine();
        }
        while (!MainFunctions.checkInput(license)) {
            System.out.println("License must be word!");
            System.out.print("Re-enter license: ");
            license = scanner.nextLine();
        }
        return license;
    }


    public static int inputPrice2(Vehicle vehicle){
        String price= scanner.nextLine();
        while (checkInput(price)){
            System.out.println("Price must be digital!");
            System.out.print("Re-enter price: ");
            price= scanner.nextLine();
        }
        while (price.isEmpty() || price.matches("[\\s]")){
            price= String.valueOf(vehicle.getPrice());
        }
        return Integer.parseInt(price);
    }
    // Input Data

    // Validate Input
    public static boolean checkInput(String string){
        return string.matches("[a-zA-Z]+")
                || string.matches("[a-zA-Z]+[0-9]+")
                || string.matches("[0-9]+[a-zA-Z]+")
                || string.matches("[0-9]+[a-zA-Z]+[0-9]+");
    }
    // Validate Input
}
