package swing_6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JFrameExample6_2 extends JFrame {
	PartsPanel2 panel; //  = new PartsPanel2();
	PartsButtonPanel buttonPanel;
	PartsRadioPanel radioPanel; // = new PartsRadioPanel();

	boolean flag = false; // true 右　false　左
	Color color = Color.BLACK;
	JButton buttonL; //左ボタン
	JButton buttonR; // 右ボタン

	ButtonGroup group; // ボタングループ；
	JRadioButton radioBlack; // ラジオボタン黒
	JRadioButton radioBlue; // ラジオボタン　青
	JRadioButton radioGreen; // ラジオボタン　緑
	JRadioButton radioRed; // ラジオボタン　赤

	public JFrameExample6_2() {
		setSize(400, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();

		panel = new PartsPanel2();
		buttonPanel = new PartsButtonPanel();
		radioPanel = new PartsRadioPanel();

		//ボタンの配置（はいち）
		buttonL = new JButton("左");
		buttonR = new JButton("右");
		buttonPanel.add(buttonL); // パネルにボタンを配置（はいち）
		buttonPanel.add(buttonR); // パネルにボタンを配置（はいち）
		
		//ボタンのイベントを有効にする
		buttonL.addActionListener(buttonPanel);
		buttonR.addActionListener(buttonPanel);

		// ラジオボタンの配置
		radioBlack = new JRadioButton("黒", true); // 初期選択
		radioBlue = new JRadioButton("青");
		radioGreen = new JRadioButton("緑");
		radioRed = new JRadioButton("赤");
		radioPanel.add(radioBlack);
		radioPanel.add(radioBlue);
		radioPanel.add(radioGreen);
		radioPanel.add(radioRed);

		//ボタングループの作成、設定 連動させる部品を決める
		group = new ButtonGroup();
		group.add(radioBlack);
		group.add(radioBlue);
		group.add(radioGreen);
		group.add(radioRed);

		//ラジオボタンのイベントを有効にする
		radioBlack.addActionListener(radioPanel);
		radioBlue.addActionListener(radioPanel);
		radioGreen.addActionListener(radioPanel);
		radioRed.addActionListener(radioPanel);

		// コンテナにパネルを設定する
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.CENTER);
		cont.add(buttonPanel, BorderLayout.NORTH);
		cont.add(radioPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample6_2();
		frame.setVisible(true);
	}

	class PartsPanel2 extends JPanel {
		public PartsPanel2() {
			setBackground(Color.WHITE);
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
			g.setColor(color);
			g.fillOval(x + 70, y + 60, 40, 50);
			g.fillOval(x + 200, y + 60, 40, 50);
		}
	}

	class PartsButtonPanel extends JPanel implements ActionListener {
		// ボタンが押されたら
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton pushButton = (JButton) e.getSource();
			// 押されたボタンを判定
			if (pushButton == buttonL) {
				flag = false;
			} else {
				flag = true;
			}
			panel.repaint();//　目が表示されているパネルを更新する
		}
	}

	class PartsRadioPanel extends JPanel implements ActionListener {
		/** ラジオボタンが押されたら　*/
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton selectRadio = (JRadioButton) e.getSource();
			//　押されたボタンの判定
			if (selectRadio == radioBlack) {
				color = Color.BLACK;
			} else if (selectRadio == radioBlue) {
				color = Color.BLUE;
			} else if (selectRadio == radioGreen) {
				color = Color.GREEN;
			} else if (selectRadio == radioRed) {
				color = Color.RED;
			}
			panel.repaint();
		}
	}
}
