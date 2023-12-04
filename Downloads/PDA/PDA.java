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
    int age = 0; //Stores user age
    int LOWER_BOUND = 14; //lower age limit for dating, constant--no hard numbers
    int realMinAge = 0; //store the computed younger boundary
    int realMaxAge = 0; //store computed older boundary
    boolean shouldContinue = true; //controls the main event loop
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
    public void getYoungerAge() { //*void does not produce result that needs to be returned 
        // Compute younger age boundary
        realMinAge = (int)Math.round((age/2.0)+7);
    }

    /**
     * Compute the older age boundary
     */
    public void getOlderAge() {
        // Compute older age boundary
        realMaxAge = (int)Math.round((age-7)*2.0);
    }

    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (shouldContinue == true) {
            System.out.println("How old are you?");
            try {
                age = scanner.nextInt();
                if (age == 0) {
                    System.out.println("You entered 0. Exiting the program.");
                    shouldContinue = false;
                }
                if (age < LOWER_BOUND && age !=0) {
                    System.out.println(age + " is too young!!");
                } else if (age !=0) { 
                    getYoungerAge(); //Compute younger and older age boundaries based on user input
                    getOlderAge();
                    System.out.println("Youngest Dating Age: " + realMinAge);
                    System.out.println("Oldest Dating Age: " + realMaxAge);
                }
            } catch (InputMismatchException error) {
                scanner.next(); //clear the invalid data and let the scanner proceed normally
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

