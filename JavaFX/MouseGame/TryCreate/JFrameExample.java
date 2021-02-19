import javax.swing.*;
import java.awt.*;

public class JFrameExample extends JFrame
{
	public JFrameExample()
	{
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Name Program");

		Container cont = getContentPane();
		MyJPanel panel = new MyJPanel();
		cont.add(panel);

		MyJPanel2 panel2 = new MyJPanel2();
		cont.add(panel2);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Hellooooo",120,170);

		Font font = new Font("Times New Roman", Font.BOLD,17);
		g.setFont(font);
		g.drawString("My Name is", 200,170);

		font = new Font("Arial", Font.BOLD,25);
		g.setFont(font);
		g.drawString("Iqbal",290,170);
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrameExample();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}

class MyJPanel extends JPanel
{
	public MyJPanel()
	{
		setBackground(Color.GREEN);
	}
}

class MyJPanel2 extends JPanel
{
	public MyJPanel2()
	{
		setBackground(Color.RED);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		String str = "JPanel2";
		Dimension d = getSize();

		FontMetrics fm = g.getFontMetrics();
		int strWidth = fm.stringWidth(str);
		int strHeight = fm.getHeight();

		int x = (d.width - strWidth)/2;
		int y = (d.height - strHeight)/2;

		g.drawString(str,x,y);
	}
}