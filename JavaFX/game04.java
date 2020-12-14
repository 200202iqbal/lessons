class game04
{
	public static void main (String [] args)
	{

		for ( int i = 0 ; i <=100 ; i++)
		{
		boolean ischeckNum = i % 3 == 0;
		
		if ( ischeckNum && i != 0)
			{
				System.out.println(i + " : is number ");
			}
			else
			{
				System.out.println(i + " : isn`t number ");
			}

		}
		
	}
}