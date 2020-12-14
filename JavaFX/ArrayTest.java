import java.util.Scanner;

public class ArrayTest
{
	public static void main (String[] args)
	{
		String password ="asb";
		

		while (true)
		{
		System.out.print("\nInput password : ");
		Scanner scn = new Scanner (System.in);
		String userData = scn.nextLine();
			if (password.equals (userData))
			{
				System.out.println("OK Login Success");
				break;
			}
			else
			{
			System.out.println("Invalid");
			}
		}
	}
}
