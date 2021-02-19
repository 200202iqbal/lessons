package swing_6;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameExaｍple6_3  extends JFrame{
	PartsPanel3 panel;	// パネル　目玉（めだま）用（よう）
	PartsTextPanel textPanel; //パネルテキスト用

	JTextField strokeText; // 線（せん）の太さ（ふとさ）を指定（してい）する
	BasicStroke stroke; // 線の太さ（せんのふとさ）

	public JFrameExaｍple6_3() {
		setSize(400, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();

		panel = new PartsPanel3();
		textPanel = new PartsTextPanel();

		// テキストフィールドの配置
		strokeText = new JTextField("1.0", 4);
		textPanel.add(strokeText);
		// テキストフィールドのイベントを有効にする
		strokeText.addActionListener(textPanel);

		// コンテナにパネルを表示しる
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.CENTER);
		cont.add(textPanel, BorderLayout.WEST);

    }
	public static void main(String[] args) {
		JFrame frame = new JFrameExaｍple6_3();
		frame.setVisible(true);

	}
	class PartsPanel3 extends JPanel {
		public PartsPanel3() {
			setBackground(Color.WHITE);
			// 線の太さを決める
			stroke = new BasicStroke(1.0f);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(stroke);
			
			int x = 0; int y = 0; // 始点
			g.drawOval(70, 50, 120, 70); // 白目　左（しろめ　ひだり）
			g.drawOval(200, 50, 120, 70); //白目　左（しろめ　ひだり）
			g.fillOval(x + 70, y + 60, 40, 50);
			g.fillOval(x + 200, y + 60, 40, 50);
		}
	}
	class PartsTextPanel extends JPanel implements ActionListener {
		/**テキストが入力されたら*/
		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField readText = (JTextField)e.getSource();
			// 入力文字列をfloat型に変換
			String inData = readText.getText();
			float size= Float.parseFloat(inData);
			// 線の太さを再設定
			stroke = new BasicStroke(size);
			panel.repaint(); //目玉のパネルを書き換え

		}


	}
}
