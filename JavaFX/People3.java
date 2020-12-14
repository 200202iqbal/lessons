public class People 
{
	public static void main (String[] args)
	{
		Tanaka tk = new Tanaka();
		tk.hello();

		Yamamoto ym = new Yamamoto();
		ym.hello();

		Yoshino yt = new Yoshino();
		yt.hello();
	}
}
class Tanaka 
{
	void hello()
	{
		String msg = "Tanaka > yosh konnichiwa";
		System.out.println(msg);
	}
}
class Yamamoto
{
	void hello()
	{
		String msg = "Yamamoto > java renshuu";
		System.out.println(msg);
	}
}
class Yoshino
{
	void hello()
	{
		String msg = "Yoshino > ALOHA";
		System.out.println(msg);
	}
}