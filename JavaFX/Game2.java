import java.util.Random;
import java.util.Scanner;
public class Game 
{
	public static void main (String[] args )
	{
		int n=0;
		Random random = new Random();
		Scanner sc = new Scanner( System.in );
		int target = random.nextInt(50);
		System.out.println();
		System.out.println("==========Check Number Game ==========\n");
		System.out.println("-----------INFO---------------");
		System.out.println("If you want surrender press 404 ");
		System.out.println("Ganbatte \n\n=================================");
		while( true )
		{
			System.out.print("your answer ? >> ");
			int answer = sc.nextInt();
			

			boolean checkAnswer = answer == target;
			boolean surrender = answer == 404;
		
			if ( checkAnswer )
			{
				System.out.println("you win !!!");
				System.out.println("-------------");
				System.out.println("\n\nTry : " + n + "x");
				break;
			}
			else if (surrender )
			{
				System.out.println("\n\n\nSurrender....");
				System.out.println("Answer : " + target);
				System.out.println("\n\nTry : " + n + "x");
				break;
			}
			else
			{
			System.out.println("you lose !!!");
			
			System.out.println();
			}
			n++;
		}
	}
}