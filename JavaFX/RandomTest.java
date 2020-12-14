import java.util.Random;

public class RandomTest
{
	public static void main (String[] args)
	{
		Random rnd = new Random();
		int randomNum = rnd.nextInt(6);
		System.out.println("\n" + randomNum);

	}
}