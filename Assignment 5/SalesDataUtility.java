/**
 * Class: CMSC203
 * Instructor:
 * Description: This class contains static utility methods used to process store sales data stored in a ragged two-dimensional array.
 * Due: 04/20/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given
 * my code to any student.
 * Print your Name here: Julian Black
 */

public class SalesDataUtility
{
    public static double getTotal(double[][] data)
    {
        double total = 0.0;

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                total += data[row][col];
            }
        }

        return total;
    }
    public static double getAverage(double[][] data)
    {
        double total = 0.0;
        int count = 0;

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                total += data[row][col];
                count++;
            }
        }

        if (count == 0)
        {
            return 0.0;
        }

        return total / count;
    }
    public static double getRowTotal(double[][] data, int row)
    {
        double total = 0.0;

        for (int col = 0; col < data[row].length; col++)
        {
            total += data[row][col];
        }

        return total;
    }
    public static double getColumnTotal(double[][] data, int col)
    {
        double total = 0.0;

        for (int row = 0; row < data.length; row++)
        {
            if (col < data[row].length)
            {
                total += data[row][col];
            }
        }

        return total;
    }
    public static double getHighestInRow(double[][] data, int row)
    {
        double highest = data[row][0];

        for (int col = 1; col < data[row].length; col++)
        {
            if (data[row][col] > highest)
            {
                highest = data[row][col];
            }
        }

        return highest;
    }
    public static double getLowestInRow(double[][] data, int row)
    {
        double lowest = data[row][0];

        for (int col = 1; col < data[row].length; col++)
        {
            if (data[row][col] < lowest)
            {
                lowest = data[row][col];
            }
        }

        return lowest;
    }
    public static double getHighestInArray(double[][] data)
    {
        double highest = data[0][0];

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                if (data[row][col] > highest)
                {
                    highest = data[row][col];
                }
            }
        }

        return highest;
    }
    public static double getLowestInArray(double[][] data)
    {
        double lowest = data[0][0];

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                if (data[row][col] < lowest)
                {
                    lowest = data[row][col];
                }
            }
        }

        return lowest;
    }
}