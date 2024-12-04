import dao.daoImpl.UserDaoImpl;
import database.Counter;
import database.Database;
import enums.Gender;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    1.add user
                    2.search By Name
                    3.update
                    4.sort
                    5.filter
                    """);
            int choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    System.out.print("user name: ");
                    String name = scanner1.nextLine();
                    System.out.print("user password: ");
                    String password = scanner1.nextLine();
                    System.out.print("user age:");
                    int age = scanner.nextInt();
                    System.out.print("gender: ");
                    String gender = scanner1.nextLine();
                    if (gender.equalsIgnoreCase("male")) {
                        System.out.println(userService.addNewUser(new User(Counter.getUserId(), name, password, age, "photo", Gender.MALE)));
                    } else if (gender.equalsIgnoreCase("female")) {
                        System.out.println(userService.addNewUser(new User(Counter.getUserId(), name, password, age, "photo", Gender.FEMALE)));
                    } else {
                        System.out.println("Error");
                    }
                }
                case 2 -> {
                    System.out.print("Name: ");
                    String name = scanner1.nextLine();
                    System.out.println(userService.searchByName(name));
                }
                case 3 -> {
                    System.out.print("Name: ");
                    String name = scanner1.nextLine();
                    System.out.print("Password: ");
                    String password = scanner1.nextLine();
                    System.out.print("photo: ");
                    String photo = scanner1.nextLine();
                    System.out.println(userService.userUpdateByName(name, password, photo));
                }
                case 4 -> {
                    System.out.print("Asc or desc: ");
                    String ascOrDesk = scanner1.nextLine();
                    if (ascOrDesk.equalsIgnoreCase("asc")) {
                        System.out.println(userService.sortByAge("asc"));
                    } else if (ascOrDesk.equalsIgnoreCase("desc")) {
                        System.out.println(userService.sortByAge("desc"));
                    } else {
                        System.out.println("error!");
                    }
                }
                case 5 -> {
                    System.out.print("Asc or desc: ");
                    String ascOrDesk = scanner1.nextLine();
                    if (ascOrDesk.equalsIgnoreCase("asc")) {
                        System.out.println(userService.fikterByAge("asc"));
                    } else if (ascOrDesk.equalsIgnoreCase("desc")) {
                        System.out.println(userService.fikterByAge("desc"));
                    } else {
                        System.out.println("error!");
                    }
                }
            }
        }
    }
}