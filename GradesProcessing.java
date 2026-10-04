import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads data about grades from input file, does some calculations,
 * and outputs  results to a text file.
 *
 * @author Enzo Kublinski Kopp
 * @version v1.0
 * @since 10/04/2026
 */
public class GradesProcessing {

    public static void main(String[] args) throws IOException {
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();

        processFile(inFile, outFile);

        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFile);
    }

    /**
     * Prompts user for input filepath and checks to see that the file exists.
     *
     * @return The verified filepath of the input file.
     * @throws IOException If an I/O error occurs.
     */
    public static String getInFile() throws IOException {
        String filePath;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        filePath = keyboard.nextLine();
        File file = new File(filePath);

        while (!file.exists()) 
        {
            System.out.println("The input file cannot be found.");
            System.out.print("Please enter a valid input file name/path: ");
            filePath = keyboard.nextLine();
            file = new File(filePath);
        }

        return filePath;
    }

    /**
     * Prompts user for the output file path.
     *
     * @return The filename or path for writing output.
     */
    public static String getOutFile() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the output file (ie output.txt): ");
        return keyboard.nextLine();
    }

    /**
     * Processes grade sets from the input file and writes some results to the output file.
     *
     * @param inFile  The source file path containing grade sets.
     * @param outFile The destination file path to create.
     * @throws IOException If an I/O error occurs during file reading/writing.
     */
    public static String processFile(String inFile, String outFile) throws IOException {
        File inputFile = new File(inFile);
        Scanner fileScanner = new Scanner(inputFile);
        PrintWriter outputWriter = new PrintWriter(outFile);

        int setNumber = 1;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
            int totalScores = 0;
            int sumScores = 0;
            double avgScore;
            int highScore = Integer.MIN_VALUE;
            int lowScore = Integer.MAX_VALUE;
            Scanner lineScanner = new Scanner(line);
            
            outputWriter.println("Set " + setNumber + " of grades calculated");


            while (lineScanner.hasNextInt()) {
                int score = lineScanner.nextInt();

                if (score == -1) {
                    break;
                }

                totalScores++;
                sumScores += score;

                if (score > highScore) {
                    highScore = score;
                }
                if (score < lowScore) {
                    lowScore = score;
                }

                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }

            lineScanner.close();

            if (totalScores == 0) {
                outputWriter.println("No grades to average");
            } else {
                avgScore = (double)sumScores/totalScores;
                outputWriter.println("Number of As: " + countA);
                outputWriter.println("Number of Bs: " + countB);
                outputWriter.println("Number of Cs: " + countC);
                outputWriter.println("Number of Ds: " + countD);
                outputWriter.println("Number of Fs: " + countF);
                outputWriter.println("The high score was: " + highScore);
                outputWriter.println("The low score was: " + lowScore);
                outputWriter.printf("The avg score is: %.1f\n", avgScore);
            }

            outputWriter.println(); 
            setNumber++;
        }

        fileScanner.close();
        outputWriter.close();

        return outFile;
    }
}