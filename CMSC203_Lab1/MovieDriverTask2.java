import java.util.Scanner;

public class MovieDriverTask2 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Boolean valid = true;
		do
		{
			Movie movie = new Movie();
			System.out.print("Enter the movie title: ");
			String title = keyboard.nextLine();
			movie.setTitle(title);
			System.out.print("Enter the movie rating: ");
			String rating = keyboard.nextLine();
			movie.setRating(rating);
			System.out.print("Enter the number of tickets sold: ");
			int sold = keyboard.nextInt();
			movie.setSoldTickets(sold);
			keyboard.nextLine();
			System.out.println(movie.toString());
			System.out.print("Do you want to enter another? (y or n)");
			char yn = keyboard.next().charAt(0);
			keyboard.nextLine();
			while(yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n')
			{
				System.out.print("Try agin, Do you want to enter another? (y or n) ");
				yn = keyboard.next().charAt(0);
				keyboard.nextLine();
			}
			if(yn == 'Y' || yn == 'y')
			{
				valid = true;
			}
			else
			{
				valid = false;
			}
		}
		while(valid == true);
		
		
		keyboard.close();
	}
}
