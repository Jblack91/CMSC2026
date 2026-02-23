
import java.util.Scanner;

public class MovieDriverTask1 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
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
		System.out.println(movie.toString());
		keyboard.close();
	}
}
