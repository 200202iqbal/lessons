import java.util.Scanner;

public class Scan 
{
	public static void main ( String[] args )
	{
		String inMessage = "input message > ";
		String outMessage = "message :  " ;
		int loop = 3;
		for ( int i = 0 ; i < loop ; i++ )
		{
		System.out.print ( inMessage );
		Scanner sc = new Scanner ( System.in );
		String msg = sc.nextLine();
		System.out.print ( outMessage + msg );
		System.out.println();
		System.out.println();
		}
	}
}