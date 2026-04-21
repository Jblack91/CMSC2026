/**
 * Class: CMSC203
 * Instructor:
 * Description: This class is the console driver for the Store Sales Data processor. It asks the user for input and output file names, reads the sales data, displays summary information, and writes the summary to a file.
 * Due: 04/20/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Print your Name here: Julian Black
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SalesAppDriver
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String inputFile = keyboard.nextLine();

        System.out.print("Enter output file name: ");
        String outputFile = keyboard.nextLine();

        try
        {
            double[][] data = SalesFileIO.readSalesData(inputFile);

            System.out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
            System.out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
            System.out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
            System.out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));

            for (int row = 0; row < data.length; row++)
            {
                System.out.printf("Row %d total: %.2f%n", row,
                        SalesDataUtility.getRowTotal(data, row));
            }

            int maxColumns = 0;

            for (int row = 0; row < data.length; row++)
            {
                if (data[row].length > maxColumns)
                {
                    maxColumns = data[row].length;
                }
            }

            for (int col = 0; col < maxColumns; col++)
            {
                System.out.printf("Column %d total: %.2f%n", col,
                        SalesDataUtility.getColumnTotal(data, col));
            }

            SalesFileIO.writeSummary(outputFile, data);
            System.out.println("Summary written to " + outputFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: input file not found.");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error: invalid number in input file.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing summary file.");
        }

        keyboard.close();
    }
}