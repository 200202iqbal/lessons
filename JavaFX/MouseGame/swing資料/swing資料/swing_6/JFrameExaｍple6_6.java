package swing_6;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExaｍple6_6  extends JFrame{
	PartsPanel5 panel;	// パネル　目玉（めだま）用（よう）
	PartsBoxPanel boxPanel; //パネルテキスト用

	BasicStroke stroke; // 線の太さ（せんのふとさ）
	JComboBox<String> strokeBox; // 線の太さを設定するコンボボックス

	public JFrameExaｍple6_6() {
		setSize(500, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();

		panel = new PartsPanel5();
		boxPanel = new PartsBoxPanel();

		// 線の太さ（初期値）を設定する
		stroke = new BasicStroke(1.0f);

		//コンボボックスの配置
		String[] listItem = {"1.0", "2.0", "4.0"};
		strokeBox =  new JComboBox<String>(listItem);
		strokeBox.setEditable(true);  // 編集可能にする
		strokeBox.setSelectedIndex(0); //　初期表示を決める
		boxPanel.add(strokeBox);
		// コンボボックスのイベントを有効にする
		strokeBox.addActionListener(boxPanel);

		// コンテナにパネルを表示しる
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.CENTER);
		cont.add(boxPanel, BorderLayout.WEST);

    }
	public static void main(String[] args) {
		JFrame frame = new JFrameExaｍple6_6();
		frame.setVisible(true);

	}
	class PartsPanel5 extends JPanel {
		public PartsPanel5() {
			setBackground(Color.WHITE);

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
	class PartsBoxPanel extends JPanel implements ActionListener {
		/**テキストが入力されたら*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// 入力文字列をfloat型に変換
			String inData = (String) strokeBox.getSelectedItem();
			float size= Float.parseFloat(inData);
			stroke = new BasicStroke(size);

					// 入力値をコンボボックスに追加する
			int n = strokeBox.getItemCount();
			boolean isExist = false;

			for(int i = 0; i < n ; i++) {
				String listData = strokeBox.getItemAt(i);
				if(inData.equals(listData)) {
					isExist = true;
				}
			}
			// 未登録の値の場合、コンボボックスに追加
			if(!isExist) {
				strokeBox.addItem(inData);
			}
			panel.repaint(); //目玉のパネルを書き換え
		}
	}
}
