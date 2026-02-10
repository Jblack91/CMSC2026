/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Building a grade calculator which takes scores and gives you an average and letter grade
 * Due: 02/09/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or 
* any source. I have not given my code to any student.
 * Print your Name here: Julian Black
*/
 
import java.util.Scanner;
import java.io.*;
public class GradeCalculator {
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		boolean configValid = true;
		int gradedCategories = 0;
		int totalWeight = 0;
		String category1 = "";
		String category2 = "";
		String category3 = "";
		int categoryWeight1 = 0;
		int categoryWeight2 = 0;
		int categoryWeight3 = 0;
		String categoryName = "";
		int categoryWeight = 0;
		String courseName = "";
		String inputName = "grades_input.txt";
		String outputName = "grades_report.txt";
		String firstName = "";
		String lastName = "";
		boolean inputGradeValid = true;
		double totalScore =  0.0;
		String gradeCategory = "";
		int numScores = 0;
		double score = 0;
		double average = 0;
		double finalGrade = 0;
		int weight = 0;
		double weightedGrade = 0;
		char letterGrade = 'a';
		boolean plusMinus = false;
		char yn;
		int wholeFinal = 0;
		double decimalFinal =0;
		String pm = "";
		
		if(args.length >= 2)
		{
			inputName = args[0];
			outputName = args[1];
		}
		else if(args.length == 1)
		{
			inputName = args[0];
		}
		
		PrintWriter out = new PrintWriter(new FileWriter(outputName));
		System.out.println("CMSC203 Grade Calculator");
		out.println("CMSC203 Grade Calculator");
		System.out.println();
		out.println();
		System.out.println("Loading configuration from gradeconfig.txt ...");
		out.println("Loading configuration from gradeconfig.txt ...");
		
		File file = new File("gradeconfig.txt");
		Scanner inputFile = new Scanner(file);
		if(!inputFile.hasNextLine())
		{
			configValid = false;
		}
		else
		{
			courseName = inputFile.nextLine();
		}
		if(!configValid || !inputFile.hasNextInt())
		{
			configValid = false;
		}
		else
		{
			gradedCategories = inputFile.nextInt();
		}
		for(int count = 0;configValid &&  count < gradedCategories; count++)
		{
			if(!inputFile.hasNext())
			{
				configValid = false;
				break;
			}
			else
			{
				categoryName = inputFile.next();
				if(!inputFile.hasNextInt())
				{
					configValid = false;
					break;
				}
				else
				{
					categoryWeight = inputFile.nextInt();
					if(count == 0)
					{
						category1 = categoryName;
						categoryWeight1 = categoryWeight;
					}
					else if(count == 1)
					{
						category2 = categoryName;
						categoryWeight2 = categoryWeight;
					}
					else if(count == 2)
					{
						category3 = categoryName;
						categoryWeight3 = categoryWeight;
					}
					totalWeight += categoryWeight; 
				}
			}
			
		}
		if(!configValid || totalWeight != 100)
		{
			System.out.println("Invalid config, Default config used");
			out.println("Invalid config, Default config used");
			category1 = "Projects";
			category2 = "Quizzes";
			category3 = "Exams";
			categoryWeight1 = 40;
			categoryWeight2 = 30;
			categoryWeight3 = 30;
			gradedCategories = 3;
			courseName = "CMSC203 Computer Science I";
			totalWeight = 100;
		}
		else
		{
			System.out.println("Configuration loaded successfully.");
			out.println("Configuration loaded successfully.");
		}
		System.out.println(); out.println();
		System.out.println("Using input file: " + inputName);
		out.println("Using input file: " + inputName);
		System.out.println("Using output file: " + outputName);
		out.println("Using output file: " + outputName);
		System.out.println(); out.println();
		System.out.println("Reading student scores...");
		out.println("Reading student scores...");
		System.out.println(); out.println();

		File gradeFile = new File(inputName);
		Scanner inputGradeFile = new Scanner(gradeFile);
		if(!inputGradeFile.hasNextLine())
		{
			inputGradeValid = false;
		}
		else
		{
			firstName = inputGradeFile.nextLine();
		}
		if(!inputGradeFile.hasNextLine())
		{
			inputGradeValid = false;
		}
		else
		{
			lastName = inputGradeFile.nextLine();
		}
		System.out.println("Student: " + firstName + " " + lastName);
		out.println("Student: " + firstName + " " + lastName);
		System.out.println("Course: " + courseName);
		out.println("Course: " + courseName);
		System.out.println(); 
		out.println();
		System.out.println("Category Results:");
		out.println("Category Results:");
		for(int j = 0; j < gradedCategories; j++)
		{
			weight = 0;
			gradeCategory = inputGradeFile.next();
			boolean categoryValid = false;
			numScores = inputGradeFile.nextInt();
			for(int i = 0; i < numScores; i++)
			{
				score = inputGradeFile.nextDouble();
				totalScore += score;
			}
			inputGradeFile.nextLine();
			average = totalScore /numScores;
			if(gradeCategory.equals(category1))
			{
				weight = categoryWeight1;
				categoryValid = true;
			}
			else if(gradeCategory.equals(category2))
			{
				weight = categoryWeight2;
				categoryValid = true;
			}
			else if(gradeCategory.equals(category3))
			{
				weight = categoryWeight3;
				categoryValid = true;
			}
			
			if(categoryValid)
			{
				weightedGrade = (average * weight)/100;
				finalGrade += weightedGrade;
				System.out.print(gradeCategory);
				System.out.print(" (");
				System.out.print(weight);
				System.out.print("%): average = ");
				System.out.println(String.format("%.2f", average));
				out.print(gradeCategory);
				out.print(" (");
				out.print(weight);
				out.print("%): average = ");
				out.println(String.format("%.2f", average));
			}
			else
			{
				System.out.print("Invalid category \n");
			}
			totalScore = 0;
			
		}
		System.out.println(); out.println();
		
		if (finalGrade <= 100 && finalGrade >= 90)
		{
			letterGrade = 'A';
		}
		
		else if (finalGrade < 90 && finalGrade >= 80)
		{
			letterGrade = 'B';
		}
		else if (finalGrade < 80 && finalGrade >= 70)
		{
			letterGrade = 'C';
		}
		else if (finalGrade < 70 && finalGrade >= 60)
		{
			letterGrade = 'D';
		}
		else if (finalGrade < 60)
		{
			letterGrade = 'F';
		}
		wholeFinal = (int)finalGrade;
		decimalFinal = finalGrade - wholeFinal;
		if(decimalFinal >= 0.85)
		{
			pm = "+";
		}
		else if(decimalFinal < 0.85 && decimalFinal > .15)
		{
			pm = "";
		}
		else
		{
			pm = "-";
		}
		System.out.print("Apply +/- grading? (Y/N): ");
		yn = keyboard.next().charAt(0);
		while(yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n')
		{
			System.out.print("Invalid input. Apply +/- grading? (Y/N): ");
			yn = keyboard.next().charAt(0);
		}
		out.print("Apply +/- grading? (Y/N): ");
		out.println(yn);
		plusMinus = (yn == 'Y' || yn == 'y');
		System.out.println();
		out.println();
		System.out.print("Overall numeric average: ");
		System.out.println(String.format("%.2f", finalGrade));

		out.print("Overall numeric average: ");
		out.println(String.format("%.2f", finalGrade));

		System.out.print("Base letter grade: ");
		System.out.println(letterGrade);

		out.print("Base letter grade: ");
		out.println(letterGrade);

		if(plusMinus && letterGrade != 'F')
		{
			System.out.print("Final letter grade: ");
			System.out.print(letterGrade);
			System.out.println(pm);

			out.print("Final letter grade: ");
			out.print(letterGrade);
			out.println(pm);
		}
		else
		{
			System.out.print("Final letter grade: ");
			System.out.println(letterGrade);

			out.print("Final letter grade: ");
			out.println(letterGrade);
		}

		System.out.println();
		out.println();

		System.out.print("Summary written to ");
		System.out.println(outputName);

		out.print("Summary written to ");
		out.println(outputName);

		System.out.println("Program complete. Goodbye!");
		out.println("Program complete. Goodbye!");
		
		System.out.println("Program written by Julian Black");
		out.println("Program written by Julian Black");
		
		out.close(); 
		inputFile.close(); 
		keyboard.close(); 
		inputGradeFile.close();
	}
}
