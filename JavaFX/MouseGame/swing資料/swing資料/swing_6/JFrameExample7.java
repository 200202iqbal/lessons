package swing_6;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExample7 extends JFrame{
	public JFrameExample7() {
		setSize(400, 300);
		setTitle("いろいろなレイアウト");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		cont.setLayout(new GridLayout(2,3));
		SamplePanel6 panel6 = new SamplePanel6();
		SamplePanel7 panel7 = new SamplePanel7();
		SamplePanel8 panel8 = new SamplePanel8();

		SamplePanel9 panel9 = new SamplePanel9();

		SamplePanel10 panel10 = new SamplePanel10();
		SamplePanel11 panel11 = new SamplePanel11();

	    cont.add(panel6);
	    cont.add(panel7);
	    cont.add(panel8);
	    cont.add(panel9);
	    cont.add(panel10);
	    cont.add(panel11);
//	    cont.add(panel8, BorderLayout.NORTH);
//	    cont.add(panel9, BorderLayout.CENTER);
//	    cont.add(panel10, BorderLayout.NORTH);
//	    cont.add(panel11, BorderLayout.CENTER);

//		JButton button1 = new JButton("A");
//		JButton button2 = new JButton("B");
//		JButton button3 = new JButton("C");
//		JButton button4 = new JButton("D");
//		JButton button5 = new JButton("E");
//		JButton button6 = new JButton("F");
//		JButton button7 = new JButton("G");
//		panel6.add(button1);
//		panel6.add(button2);
//		panel6.add(button3);
//
//		panel7.setLayout(new GridLayout(2,2));
//		panel7.add(button4);
//		panel7.add(button5);
//		panel7.add(button6);
//		panel7.add(button7);
//		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
//		panel6.add(button1);
//		panel6.add(button2);
//		panel6.add(button3);
//
//		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
//		panel7.add(button4);
//		panel7.add(button5);
//		panel7.add(button6);
//		panel7.add(button7);
//		JLabel label1 = new JLabel("ラベル１");
//		JLabel label2 = new JLabel("ラベル２");
//		JLabel label3 = new JLabel("ラベル３");
//		JLabel label4 = new JLabel("ラベル４");
//		JLabel label5 = new JLabel("ラベル５");
//		JLabel label6 = new JLabel("ラベル６");
//		JLabel label7 = new JLabel("ラベル７");
//		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
//		panel6.add(label1);
//		panel6.add(label2);
//		panel6.add(label3);
//
//		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
//		panel7.add(label4);
//		panel7.add(label5);
//		panel7.add(label6);
//		panel7.add(label7);



	}
	public static void main(String[] args) {
		JFrame frame = new JFrameExample7();
		frame.setVisible(true);

	}

}
class SamplePanel6 extends JPanel {
	public SamplePanel6() {
		setBackground(Color.WHITE);
	}
}

class SamplePanel7 extends JPanel {
	public SamplePanel7() {
		setBackground(Color.RED);
	}
}
class SamplePanel8 extends JPanel {
	public SamplePanel8() {
		setBackground(Color.GREEN);
	}
}
class SamplePanel9 extends JPanel {
	public SamplePanel9() {
		setBackground(Color.BLUE);
	}
}
class SamplePanel10 extends JPanel {
	public SamplePanel10() {
		setBackground(Color.YELLOW);
	}
}
class SamplePanel11 extends JPanel {
	public SamplePanel11() {
		setBackground(Color.CYAN);
	}
}

