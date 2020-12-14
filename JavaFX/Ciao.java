public class Ciao {
	public static void main (String[] args)
	{
		int loop = 1009;
		int loop2 = 0;
		int loop3 = 15;
		String msg = " : Ciao !";
		String msg2 = " Selamat pagi ";
		for ( int i = 0 ; i < loop ; i++ )
		{
			int n = i + 1;
			System.out.println( n + msg) ;
		}

		while ( loop2  < loop3  )
		{
			System.out.println ( msg2);
			loop2++;
		}
	}

}