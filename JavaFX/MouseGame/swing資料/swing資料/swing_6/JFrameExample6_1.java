package swing_6;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExample6_1 extends JFrame {

	public JFrameExample6_1() {
		setSize(400, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		PartsPanel1 panel1 = new PartsPanel1();
		cont.add(panel1);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample6_1();
		frame.setVisible(true);
	}
}

class PartsPanel1 extends JPanel implements ActionListener {
	boolean flag = false; // true 右　false　左
	JButton buttonL; //左ボタン
	JButton buttonR; // 右ボタン

	public PartsPanel1() {
		setBackground(Color.WHITE);

		//ボタンの配置（はいち）
		buttonL = new JButton("左");
		buttonR = new JButton("右");
		add(buttonL); // パネルにボタンを配置（はいち）
		add(buttonR);

		//ボタンのイベントを有効（ゆうこう）にする
		//　ボタンを押（お）すとイベントが動（うご）く
		buttonL.addActionListener(this);
		buttonR.addActionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0;
		int y = 0; // 始点
		//黒目（くろめ）の移動分（いどうぶん）
		if (flag == true) {
			x = 80;
		} else {
			x = 0;
		}
		g.drawOval(70, 50, 120, 70); // 白目　左（しろめ　ひだり）
		g.drawOval(200, 50, 120, 70); //白目　左（しろめ　ひだり）
		g.fillOval(x + 70, y + 60, 40, 50);
		g.fillOval(x + 200, y + 60, 40, 50);
	}

	// ボタンが押されたら
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pushButton = (JButton) e.getSource();
		if (pushButton == buttonL) {
			flag = false;
		} else {
			flag = true;
		}
		repaint();
	}

}
