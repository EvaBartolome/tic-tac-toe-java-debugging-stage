import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Permissible Dating Age program
 *
 * @author Mr. Jaffe
 * @version 2021-06-22 Version 1.0.0
 */
public class PDA
{
    Scanner scanner = new Scanner(System.in); // Create a Scanner instance as an instance variable
    int age;
    int LOWER_BOUND = 0;
    boolean shouldContinue = true;
    /**
     * Constructor for objects of class PDA
     */
    public PDA()
    {
        scanner = new Scanner(System.in); // Instantiate the Scanner using System.in
    }

    /**
     * Compute the younger age boundary
     */
    private int getYoungerAge(int age) {
        // Compute younger age boundary based on the formula
        double youngerAge = age / 2.0 + 7;
        return (int) Math.floor(youngerAge);
    }

    /**
     * Compute the older age boundary
     */
    private int getOlderAge(int age) {
        // Compute older age boundary based on the formula
        double olderAge = (age - 7) * 2.0;
        return (int) Math.ceil(olderAge);
    }

    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (shouldContinue = true) {
            System.out.println("How old are you?");
            try {
                age = scanner.nextInt();
                System.out.println(age);
                if (age == 0) {
                    System.out.println("You entered 0. Exiting the program.");
                    shouldContinue = false;
                    break; // Exit the loop
                }
                if (age < LOWER_BOUND) {
                    System.out.println(age+" is too young!!");
                } else {
                    int youngerAge = getYoungerAge(age);
                    int olderAge = getOlderAge(age);
                    System.out.println("Youngest Dating Age: " + youngerAge);
                    System.out.println("Oldest Dating Age: " + olderAge);
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("Please enter an integer");
            }
        }
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}
