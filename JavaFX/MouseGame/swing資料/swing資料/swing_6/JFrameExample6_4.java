package swing_6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JFrameExample6_4 extends JFrame {
	Rectangle[] data = new Rectangle[5];

	PartsPanel4 panel; //目玉用
	PartListPanel1 listPanel; // パネル（コンポボックス用）

	/**形状選択リスト*/
	JList<String> listFrame; // 枠の形状；
	JList<String> listWL; // 白目　左の形状
	JList<String> listWR; // 白目　右の形状
	JList<String> listBL; // 黒目　左の形状；
	JList<String> listBR; //　黒目　右の形状；
	/**リストの選択肢*/
	static String[] sharpItem = { "四角(line)", "四角(fill)", "楕円(line)", "楕円(fill)" };

	public JFrameExample6_4() {
		setSize(600, 400);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//データの初期化
		int x = 100;
		data[0] = new Rectangle(x + 50, 40, 300, 100); // 枠
		data[1] = new Rectangle(x + 70, 50, 120, 70); // 白目　左
		data[2] = new Rectangle(x + 200, 50, 120, 70); // 白目　右
		data[3] = new Rectangle(x + 70, 60, 40, 50); // 黒目　左
		data[4] = new Rectangle(x + 200, 60, 40, 50); // 黒目　右

		panel = new PartsPanel4(); //目玉描画用パネル
		listPanel = new PartListPanel1(); // リスト用パネル

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

		listFrame = new JList<String>(sharpItem); //枠
		listFrame.setSelectedIndex(0); // 枠の形状　初期値は四角(line)
		listPanel.add(listFrame); //パネルに貼る
		listFrame.addListSelectionListener(listPanel); // イベントを設定する

		listWL = new JList<String>(sharpItem); //白目　左
		listWL.setSelectedIndex(0); // 枠の形状　初期値は楕円（line)
		listPanel.add(listWL); //パネルに貼る
		listWL.addListSelectionListener(listPanel); // イベントを設定する

		listWR = new JList<String>(sharpItem); //白目　右
		listWR.setSelectedIndex(0); // 枠の形状　初期値は楕円（line)
		listPanel.add(listWR); //パネルに貼る
		listWR.addListSelectionListener(listPanel); // イベントを設定する

		listBL = new JList<String>(sharpItem); //黒目　左
		listBL.setSelectedIndex(0); // 枠の形状　初期値は楕円（fill)
		listPanel.add(listBL); //パネルに貼る
		listBL.addListSelectionListener(listPanel); // イベントを設定する

		listBR = new JList<String>(sharpItem); //黒目　右
		listBR.setSelectedIndex(0); // 枠の形状　初期値は楕円（fill)
		listPanel.add(listBR); //パネルに貼る
		listBR.addListSelectionListener(listPanel); // イベントを設定する

	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample6_4();
		frame.setVisible(true);
	}

	class PartsPanel4 extends JPanel {
		public PartsPanel4() {
			setBackground(Color.CYAN);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 図形（ずけい）の形状（けいじょう）を選択（せんたく）する
			selectPaint(g, data[0], listFrame.getSelectedIndex());
			selectPaint(g, data[1], listWL.getSelectedIndex());
			selectPaint(g, data[2], listWR.getSelectedIndex());
			selectPaint(g, data[3], listBL.getSelectedIndex());
			selectPaint(g, data[4], listBR.getSelectedIndex());
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

	class PartListPanel1 extends JPanel implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			panel.repaint(); // 目が表示されているパネルを更新する。
		}
	}

}
