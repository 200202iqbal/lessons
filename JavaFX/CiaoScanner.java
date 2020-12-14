import java.util.Scanner;

public class CiaoScanner 
{
	public static void main ( String[] args )
	{
		String inName = "input your name > ";
		String inMsg = "input your message > ";
		Scanner sc = new Scanner(System.in);
		
		System.out.print ( inName ) ;
		String scnName = sc.nextLine();
		System.out.print ( inMsg );
		String  scnMessage = sc.nextLine();
		 System.out.println();
		for ( int i = 0 ; i < 10 ; i++) 
		{
			System.out.println ( i +  " : " + scnMessage + " ! from " + scnName );
		}
	}
}