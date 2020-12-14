import java.util.Scanner;
public class MethodTest2
{
	public static void main ( String [] args)
	{
		Scanner scn = new Scanner  (System.in );
		System.out.print("insert name >>> ");
		String scnName = scn.nextLine();
		System.out.println();
		System.out.println("------------------------");
		
		hello(scnName);
		hello("Tanaka");
		hello("Yamamoto");
		hello("Yoshino");

	}

	static void hello(String name )
	{
		String msg = "Aloha " + name + "!";
		String msg2 = "Hello " + name + "!";

		boolean checkYoshino = name.equals("Yoshino") || name.equals("yoshino");

		if ( checkYoshino  )
		{
			System.out.println( msg );
		}
		else
		{
			System.out.println( msg2 );
		}
		
	}

}