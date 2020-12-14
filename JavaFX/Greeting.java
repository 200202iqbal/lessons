import java.util.Scanner;
public class Greeting
{
	public static void main (String[] args)
	{
		String msg = getGreeting();
		System.out.println(msg);

	}

	public static String getGreeting()
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("your name > ");
		String name = sc.nextLine();

		String msg = "[HELLO, !! " + name + " ]";

		return msg;
	}
}