import java.util.Scanner;

public class Greeting 
{
	public static void main ( String[] args )
	{
		String inMessage = "input name > ";
		String outMessage = "message :  " ;

		System.out.print ( inMessage );
		Scanner sc = new Scanner ( System.in );
		String msg = sc.nextLine();
		System.out.print ( "Aloha ! " + msg );
		System.out.println();
	}
}