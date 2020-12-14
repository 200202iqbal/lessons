public class Calc 
{
	static int tashizan (int a , int b ) 
	{
		return a + b ;
	}

	 static int genzan ( int a,int b )
	{
		return a - b ;
	}
	public static void main (String[] args )
	{
		int a = 15 ;
		int b = 5 ;
		System.out.println( "Tashizan a + b : "  + tashizan(a,b));
		System.out.println("Genzan a - b : " + genzan(a,b));
	}
}