import java.util.Scanner;
public class ScannerTest
{
	public static void main (String[] args)
	{
		Scanner scn = new Scanner (System.in);
		System.out.print ("input message > " );
		String msg = scn.nextLine();
		System.out.println("show message > " + msg);

	}
}