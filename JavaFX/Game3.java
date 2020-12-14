import java.util.Scanner;
import java.util.Random;


public class Game
{

	int health;
	int power;

	Game3(int health, int power )
	{
		this.health = health;
		this.power = power;
	}

	void ShowStat ()
	{
		System.out.println ( "Health : " + health + " Power : " + power );
	}

	public static void main (String[] args )
	{
		System.out.println("######################");
		System.out.println("Welcome ...");
		System.out.println("######################\n");

		
		System.out.println("1. Start ");
		System.out.println("2. Exit ");

		Scanner scn = new Scanner (System.in);
		System.out.print ("\nchoose >>> ");
		int optionMenu = scn.nextInt();

		if ( optionMenu == 1 )
		{
			System.out.println("Start....");
			System.out.println();
			System.out.println("Choose your digimon");
			System.out.print("1. Agumon 2.Gabumon");
			System.out.println("\n");
			System.out.print( "choose >>> ");
			optionMenu = scn.nextInt();

				if (optionMenu == 1 )
				{
					System.out.println("You choose Agumon\n");
					Game Agumon = new Game(100, 7);
					
					System.out.println();
					System.out.println("1. Action 2.Show Status");
					System.out.print( "choose >>> ");
					optionMenu = scn.nextInt();
					
					if (optionMenu == 1 )
					{
						System.out.println("1. Walk 2.Sing 3.Sleep");
						System.out.print( "choose >>> ");
						optionMenu = scn.nextInt();

					}
					else if (optionMenu == 2)
					{
						System.out.print("Agumon : ");
						 Agumon.ShowStat();

					}
					

				}
				else
				{
					System.out.println("You choose Gabumon");
				}


		}
		else
		{
			System.out.println("######################");
			System.out.println("Exit Game...Bye Bye T_T ");
			System.out.println("######################");
		}


	}


}