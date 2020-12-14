import java.util.Scanner;
public class MethodTest 
{
	public static void main (String[] args)
	{
		Scanner scn = new Scanner ( System.in );
		System.out.print ( "who are you ? >>> ");
		String name2 = scn.nextLine();
		
		System.out.print ( "student number ? >>> ");
		int scnStudNum = scn.nextInt();

		System.out.println("--------Show---------");
		Hello(name2);
		NumberStudent(scnStudNum);
		System.out.println();
		yoshino();
		tanaka();
		yamamoto();

	}

	public static void Hello (String name )
	{
		System.out.println ("Welcome Master " + name);
	}
	static void NumberStudent ( int studNum )
	{
		System.out.println ("Student number  " + studNum);
	}

	public static void yoshino() 
	{
       System.out.println( "問題あれば、楽しいですね！" );
     }
     
     public static void tanaka() 
     {
       System.out.println( "ちゃんと学校に来てね！" );
       System.out.println( "いいですね～！" );
     }
     
     public static void yamamoto() 
     {
       System.out.println( "ほらほら、みて！" );
     }
}