import Day_1.Day1;
import Day_2.Day2;
import Day_4.Day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solutions {

    private Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to choose the given days and then the answer to the first part or the second part of the day.
     */
    public void chooseSolutionsForTheDay() {
        System.out.println("Choose a day:");
        int usersDayChoice;
        boolean isANumber;
        do{
            try{
                System.out.println("""
                Day 1: Trebuchet?!
                Day 2: Cube Conundrum
                Day 4: Scratchcards""");
                usersDayChoice = sc.nextInt();
                if (usersDayChoice == 1) {
                    Day1 day1 = new Day1();
                    day1.readInputFromFile();
                    int usersPartChoice;
                    System.out.println("Choose answer for Part One(1) or Part Two(2):");
                    usersPartChoice = sc.nextInt();
                    while(usersPartChoice != 1 || usersPartChoice != 2){
                        System.out.println("Invalid number");
                        System.out.println("Choose answer for Part One(1) or Part Two(2):");
                        usersPartChoice = sc.nextInt();
                    }
                    if (usersPartChoice == 1) {
                        System.out.println("The answer for Part One is: " + day1.partOne());
                    }
                    if (usersPartChoice == 2) {
                        System.out.println("The answer for Part Two is: " + day1.partTwo());
                    }

                }
                if (usersDayChoice == 2) {
                    Day2 day2 = new Day2();
                    day2.readInputFromFile();
                    int usersPartChoice;
                    System.out.println("Choose answer for Part One(1) or Part Two(2):");
                    usersPartChoice = sc.nextInt();
                    while(usersPartChoice != 1 || usersPartChoice != 2){
                        System.out.println("Invalid number");
                        System.out.println("Choose answer for Part One(1) or Part Two(2):");
                        usersPartChoice = sc.nextInt();
                    }
                    if (usersPartChoice == 1) {
                        System.out.println("The answer for Part One is: " + day2.partOne());
                    }
                    if (usersPartChoice == 2) {
                        System.out.println("The answer for Part Two is: " + day2.partTwo());
                    }
                }
                if (usersDayChoice == 4) {
                    Day4 day4 = new Day4();
                    day4.readInputFromFile();
                    int usersPartChoice;
                    System.out.println("Choose answer for Part One(1) or Part Two(2):");
                    usersPartChoice = sc.nextInt();
                    while(usersPartChoice != 1 || usersPartChoice != 2){
                        System.out.println("Invalid number");
                        System.out.println("Choose answer for Part One(1) or Part Two(2):");
                        usersPartChoice = sc.nextInt();
                    }
                    if (usersPartChoice == 1) {
                        System.out.println("The answer for Part One is: " + day4.partOne());
                    }
                    if (usersPartChoice == 2) {
                        System.out.println("The answer for Part Two is: " + day4.partTwo());
                    }

                }
                isANumber = true;
            }catch (InputMismatchException e){
                System.out.println("Incorrect input!");
                isANumber = false;
                sc.next();

            }
        }while (!isANumber);



    }
}
