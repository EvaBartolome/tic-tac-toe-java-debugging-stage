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
    Scanner scanner = new Scanner(System.in);// Create a Scanner instance as an instance variable
    int age;
    int LOWER_BOUND = 0;
    /**
     * Constructor for objects of class PDA
     */
    public PDA()
    {
        scanner = new Scanner(System.in); // Instantiate the Scanner using System.in

    }

    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (true) {
            System.out.println("How old are you?");
            try {
                age = scanner.nextInt();
                System.out.println(age);
                if (age < LOWER_BOUND) {
                    System.out.println(age+" is too young!!");
                } else {
                    System.out.println("Computations go here");                
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
