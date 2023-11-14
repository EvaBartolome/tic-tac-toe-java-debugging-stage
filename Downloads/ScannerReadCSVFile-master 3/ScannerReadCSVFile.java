import java.util.Scanner; //read contents of the file line by line
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerReadCSVFile {
    public void run() throws FileNotFoundException {
        File dataFile = new File("TestScoresByClass.csv"); // Instantiate a File object
        Scanner scanner = new Scanner(dataFile);  // Instantiate a Scanner object that uses the file
        scanner.useDelimiter("\n"); //Set the delimiter as new-line character, read data one line at a time

        System.out.println("Class: Avg score"); //print header

        scanner.nextLine(); //skip header line

        while (scanner.hasNext()) { //continues as long as there is data in file
            String line = scanner.nextLine(); // line reads the next line from file w/ scanner object--stores the entire line as a single string in the line variable. 
            String[] values = line.split(","); //creates new array of strings named values, splits line into an array of strings representing 10 test scores for each class

            if (values.length >= 11) { //ensures that there is at least 11 values of data in the values array to process
                String classNumber = values[0]; //extracts the class number from the values array
                int totalScore = 0; //accumulate the sum of the 10 test scores for the class section (in loop, test scores are added to calculate the overall score for the class section)

                for (int i = 1; i < values.length; i++) { // iterates through 10 test scores for class section--adds them to the totalScore variable
                    totalScore += Integer.parseInt(values[i]); //convert the string representation of test score to integer and adds it to the totalScore variable
                    //i is index to access individual test scores within the values array. values[i] retrieves string representation of test score at index i in values array
                }

                int averageScore = Math.round((float) totalScore / (values.length - 1)); //calculates average of scores, division in floating-point arithmetic, Math.round--the result to nearest whole number

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