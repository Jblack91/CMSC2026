/**
 * Class: CMSC203
 * Instructor:
 * Description: This class handles reading sales data from a file into a ragged two-dimensional array and writing a sales summary to an output file.
 * Due: 04/20/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Print your Name here: Julian Black
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SalesFileIO
{
    public static double[][] readSalesData(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        int rowCount = 0;

        while (inputFile.hasNextLine())
        {
            inputFile.nextLine();
            rowCount++;
        }

        inputFile.close();

        double[][] data = new double[rowCount][];

        inputFile = new Scanner(file);

        int row = 0;

        while (inputFile.hasNextLine())
        {
            String line = inputFile.nextLine().trim();

            if (line.length() == 0)
            {
                data[row] = new double[0];
            }
            else
            {
                String[] values = line.split("\\s+");
                data[row] = new double[values.length];

                for (int col = 0; col < values.length; col++)
                {
                    data[row][col] = Double.parseDouble(values[col]);
                }
            }

            row++;
        }

        inputFile.close();
        return data;
    }
    public static void writeSummary(String filename, double[][] data) throws IOException
    {
        PrintWriter outputFile = new PrintWriter(filename);

        outputFile.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        outputFile.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        outputFile.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        outputFile.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));

        for (int row = 0; row < data.length; row++)
        {
            outputFile.printf("Row %d total: %.2f%n", row,
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
            outputFile.printf("Column %d total: %.2f%n", col,
                    SalesDataUtility.getColumnTotal(data, col));
        }

        outputFile.close();
    }
}