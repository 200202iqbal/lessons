package swing_6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameExample6 extends JFrame {
	public JFrameExample6() {
		setSize(400, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		SamplePanel1 panel1 = new SamplePanel1();
		SamplePanel2 panel2 = new SamplePanel2();
		SamplePanel3 panel3 = new SamplePanel3();
		SamplePanel4 panel4 = new SamplePanel4();
		SamplePanel5 panel5 = new SamplePanel5();

		cont.add(panel1, BorderLayout.CENTER);
		cont.add(panel2, BorderLayout.NORTH);
		cont.add(panel3, BorderLayout.SOUTH);
		cont.add(panel4, BorderLayout.WEST);
		cont.add(panel5, BorderLayout.EAST);

		JButton button1 = new JButton("A");
		JButton button2 = new JButton("B");
		JButton button3 = new JButton("C");
		JButton button4 = new JButton("D");
		JButton button5 = new JButton("E");

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);

		JRadioButton radio1 = new JRadioButton("あ");
		JRadioButton radio2 = new JRadioButton("い");
		JRadioButton radio3 = new JRadioButton("う");
		JRadioButton radio4 = new JRadioButton("え");
		JRadioButton radio5 = new JRadioButton("お");

		panel2.add(radio1);
		panel2.add(radio2);
		panel2.add(radio3);
		panel2.add(radio4);
		panel2.add(radio5);

		JTextField text1 = new JTextField("a",1);
		JTextField text2 = new JTextField("b",2);
		JTextField text3 = new JTextField("c",3);
		JTextField text4 = new JTextField("d",4);
		JTextField text5 = new JTextField("e",5);

		panel3.add(text1);
		panel3.add(text2);
		panel3.add(text3);
		panel3.add(text4);
		panel3.add(text5);

		String [] strList = { "〇", "△", "□" , "×"};
		JList<String> list = new JList<String>(strList);
		panel4.add(list);

		String[] strCombo = {"●", "■", "▲", "×"};
		JComboBox<String> comboBox = new JComboBox<String>(strCombo);
		panel5.add(comboBox);

		JTextArea area = new JTextArea("aiueo", 5, 25);
		area.setBackground(Color.PINK);
		panel1.add(area);

		JCheckBox check1 = new JCheckBox("1");
		JCheckBox check2 = new JCheckBox("2");
		JCheckBox check3 = new JCheckBox("3");
		JCheckBox check4 = new JCheckBox("4");
		JCheckBox check5 = new JCheckBox("5");
		panel1.add(check1);
		panel1.add(check2);
		panel1.add(check3);
		panel1.add(check4);
		panel1.add(check5);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrameExample6();
		frame.setVisible(true);
	}
}

class SamplePanel1 extends JPanel {
	public SamplePanel1() {
		setBackground(Color.WHITE);
	}
}

class SamplePanel2 extends JPanel {
	public SamplePanel2() {
		setBackground(Color.RED);
	}
}

class SamplePanel3 extends JPanel {
	public SamplePanel3() {
		setBackground(Color.GREEN);
	}
}

class SamplePanel4 extends JPanel {
	public SamplePanel4() {
		setBackground(Color.BLUE);
	}
}

class SamplePanel5 extends JPanel {
	public SamplePanel5() {
		setBackground(Color.YELLOW);
	}
}
