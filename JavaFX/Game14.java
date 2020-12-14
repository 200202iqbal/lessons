import java.util.Scanner;

public class Game 
{
	public static void main (String[] args)
	{
		int refrNum = 8;
		Scanner scn = new Scanner (System.in);
		

		while (true)
		{
			System.out.print("input number : ");
			int inNum = scn.nextInt();
			if ( inNum == refrNum )
			{ 
				System.out.println("\nOK !");
				break;
			}
			else if (inNum < refrNum )
			{
				System.out.println("\nLarger !");
			}
			else
			{
				System.out.println("\nSmaller !");
			}
		}
	}

}