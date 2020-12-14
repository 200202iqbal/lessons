import java.util.Scanner;
class Teacher
{
	String name ;
	String msg ;
	int HealthPoint;
	int attackValue;
	int NewHP;


	Teacher(String name, String msg, int HealthPoint, int attackValue)
	{
		this.name = name;
		this.msg = msg;
		this.HealthPoint = HealthPoint;
		this.attackValue = attackValue;
	}

	void hello(String strName)
	{

		System.out.println( name + "先生。" + strName +","+ msg );
	}

	 void attack(Teacher name1, Teacher name2)
	{
		if ( name2.HealthPoint <= 0)
		{
			System.out.println( name2.name + "を倒しました.");
			
		//	name2.HealthPoint = 0;
		}
		System.out.println();
		System.out.println(name1.name + "は" + name2.name + "を攻撃する");
		name2.NewHP = name2.HealthPoint - name1.attackValue;
		System.out.println(name2.name + "に" +name1. attackValue + "のダメージ(damage");
		System.out.println(name2.name + "のHPは " + name2.NewHP);
		
		name2.HealthPoint = name2.NewHP;

		
	}
}


public class People 
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("私は");
		String strName = sc.nextLine();

		Teacher Tanaka = new Teacher("田中", "お元気ですか？", 10, 5);
		Tanaka.hello(strName);

		Teacher Yamamoto = new Teacher("山本" , "出席足りてましか。" ,8, 5);
		Yamamoto.hello(strName);

		Teacher Yoshino = new Teacher("吉野", "ALOHA" , 5, 5);
		Yoshino.hello(strName);

		Tanaka.attack(Tanaka, Yamamoto);
		Yoshino.attack(Tanaka, Yoshino);
		//Tanaka.attack(Tanaka.name, Yamamoto.name, Yamamoto.HealthPoint, Tanaka.attackValue);
		Tanaka.attack(Tanaka, Yamamoto);
		Tanaka.attack(Tanaka, Yamamoto);
	}
}