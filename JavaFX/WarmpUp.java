import java.util.Scanner;
public class WarmpUp
{
	public static void main (String[] args)
	{
		String[] data = getData();
		showData(data);
	}


	public static String[] getData( )
	{
		System.out.println ("getData()");
		String[] fruits = new String[3];
		Scanner sc = new Scanner (System.in);
		for (int i = 0 ; i < 3 ; i++)
		{
			System.out.print(" fruit : ");
			fruits[i] = sc.nextLine();
		}
		return fruits;

	}
	public static void showData (String[] name)
	{
		for ( int i = 0 ; i < 3 ; i++)
		{
			System.out.println(name[i]);
		}
		

	}
}