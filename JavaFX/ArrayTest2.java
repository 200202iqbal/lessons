import java.util.Scanner;

public class ArrayTest
{
	public static void main (String[] args)
	{
		String name = "Yoshino";
		String[] names = {"Yoshino","Tanaka", "Yamamoto"};

		System.out.println(name);

		System.out.println( names[1] + " comes out !");
		
		for ( String loop : names )
		{
			System.out.println(loop);
		}

		System.out.println("///////Using Scanner/////////");
		
		Scanner scn = new Scanner (System.in);
		
		for ( int i = 0 ; i < names.length ; i ++ )
		{
			System.out.print ("input name >>> ");
			names[i] = scn.nextLine();
		}

		System.out.println("\noutput name ; \n");

		for (String output : names)
		{
			System.out.println(output);
		}
	}
}
