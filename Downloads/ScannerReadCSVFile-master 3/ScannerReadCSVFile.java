import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerReadCSVFile {
    public void run() throws FileNotFoundException {
        File dataFile = new File("TestScoresByClass.csv"); // Instantiate a File object
        Scanner scanner = new Scanner(dataFile);  // Instantiate a Scanner object that uses the file
        scanner.useDelimiter("\n"); //Set the delimiter as new-line character,read data one line at a time

        System.out.println("Class: Average score"); //print header

        scanner.nextLine(); //skip header line

        while (scanner.hasNext()) {
            String line = scanner.nextLine(); // line reads the next line from file w/ scanner object--stores the entire line as a single string in the line variable. 
            String[] values = line.split(","); //splits line into an array of strings, line of comma-separated numbers representing 10 test scores for each class

            if (values.length >= 11) {
                String classNumber = values[0]; //extracts the class number from the values array
                int totalScore = 0; //accumulate the sum of the 10 test scores for the class section (in loop, test scores are added to calculate the overall score for the class section)

                for (int i = 1; i < 11; i++) { // iterates through 10 test scores for class section--adds them to the totalScore variable
                  totalScore += Integer.parseInt(values[i]); //convert the string representation of the test score to an integer and adds it to the totalScore variable
                  //i is index to access individual test scores within the values array. values[i] retrieves string representation of test score at index i in values array
                }

                int averageScore = totalScore / 10; //calculates average of scores

                System.out.println(classNumber + ": " + averageScore); //prints average score with class
            }
        }
    }

    public static void main(String[] args) {
        try {
            ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("There's an error someplace. Try using the debugger to find it!");
        }
    }
}