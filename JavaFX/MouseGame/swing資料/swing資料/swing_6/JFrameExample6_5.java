package swing_6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameExample6_5 extends JFrame {
	Rectangle[] data = new Rectangle[5];

	PartsPanel5 panel; //目玉用
	PartListPanel2 listPanel; // パネル（コンポボックス用）

	/**形状選択リスト*/
	JComboBox<String> comboFrame; // 枠の形状；
	JComboBox<String> comboWL;// 白目　左の形状
	JComboBox<String> comboWR; // 白目　右の形状
	JComboBox<String> comboBL; // 黒目　左の形状；
	JComboBox<String> comboBR; //　黒目　右の形状；
	/**リストの選択肢*/
	static String[] sharpItem = { "四角(line)", "四角(fill)", "楕円(line)", "楕円(fill)" };

	public JFrameExample6_5() {
		setSize(600, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//データの初期化
		int x = 100;
		data[0] = new Rectangle(x + 50, 40, 300, 100); // 枠
		data[1] = new Rectangle(x + 70, 50, 120, 70); // 白目　左
		data[2] = new Rectangle(x + 200, 50, 120, 70); // 白目　右
		data[3] = new Rectangle(x + 70, 60, 40, 50); // 黒目　左
		data[4] = new Rectangle(x + 200, 60, 40, 50); // 黒目　右

		panel = new PartsPanel5(); //目玉描画用パネル
		listPanel = new PartListPanel2(); // リスト用パネル

		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.CENTER);
		cont.add(listPanel, BorderLayout.NORTH);

		JLabel labelFrame = new JLabel("枠", JLabel.CENTER);
		JLabel labelWL = new JLabel("左白目", JLabel.CENTER);
		JLabel labelWR = new JLabel("右白目", JLabel.CENTER);
		JLabel labelBL = new JLabel("左黒目", JLabel.CENTER);
		JLabel labelBR = new JLabel("右黒目", JLabel.CENTER);

		listPanel.setLayout(new GridLayout(2, 5, 10, 0));
		listPanel.add(labelFrame);
		listPanel.add(labelWL);
		listPanel.add(labelWR);
		listPanel.add(labelBL);
		listPanel.add(labelBR);

		comboFrame = new JComboBox<String>(sharpItem); //枠
		comboFrame.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(comboFrame); //パネルに貼る
		comboFrame.addActionListener(listPanel); // イベントを設定する

		comboWL = new JComboBox<String>(sharpItem); //枠
		comboWL.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(comboWL); //パネルに貼る
		comboWL.addActionListener(listPanel); // イベントを設定する

		comboWR = new JComboBox<String>(sharpItem); //枠
		comboWR.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(comboWR); //パネルに貼る
		comboWR.addActionListener(listPanel); // イベントを設定する

		comboBL = new JComboBox<String>(sharpItem); //枠
		comboBL.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(comboBL); //パネルに貼る
		comboBL.addActionListener(listPanel); // イベントを設定する

		comboBR = new JComboBox<String>(sharpItem); //枠
		comboBR.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(comboBR); //パネルに貼る
		comboBR.addActionListener(listPanel); // イベントを設定する

	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample6_5();
		frame.setVisible(true);
	}

	class PartsPanel5 extends JPanel {
		public PartsPanel5() {
			setBackground(Color.CYAN);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 図形（ずけい）の形状（けいじょう）を選択（せんたく）する
			selectPaint(g, data[0], comboFrame.getSelectedIndex());
			selectPaint(g, data[1], comboWL.getSelectedIndex());
			selectPaint(g, data[2], comboWR.getSelectedIndex());
			selectPaint(g, data[3], comboBL.getSelectedIndex());
			selectPaint(g, data[4], comboBR.getSelectedIndex());
		}

		public void selectPaint(Graphics g, Rectangle r, int mode) {
			switch (mode) {
			case 0:g.drawRect(r.x, r.y, r.width, r.height);break; //四角(line)
			case 1:g.fillRect(r.x, r.y, r.width, r.height);break; //四角(fill)
			case 2:g.drawOval(r.x, r.y, r.width, r.height);break; // 楕円（line)
			case 3:g.fillOval(r.x, r.y, r.width, r.height);break; //　楕円(fill)
			}
		}
	}

	class PartListPanel2 extends JPanel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.repaint(); // 目が表示されているパネルを更新する。
		}
	}

}
