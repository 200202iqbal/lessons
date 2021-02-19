package Swing7;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameThreadEx4 extends JFrame {
	// 複数（ふくすう）のスレッド情報（じょうほう）を管理すリスト
	private List<Thread> threadList = new ArrayList<Thread>();

	public JFrameThreadEx4() {
		setSize(400, 300);
		setTitle("画像の移動");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		ThreadPanel4 panel = new ThreadPanel4();
		cont.add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameThreadEx4();
		frame.setVisible(true);
	}

	class ThreadPanel4 extends JPanel {

	public ThreadPanel4() {
		setBackground(Color.YELLOW);

		RunButton button = new RunButton("Create", this);
		add(button);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ボタンが押されるごとに新しいスレッドを読み込んで画面に表示する
		for(int i = 0; i < threadList.size(); i++) {
			CharaThread charaThread = (CharaThread) threadList.get(i);
			g.drawImage(charaThread.getImage(), charaThread.getPoint().x,charaThread.getPoint().y, this);
		}
	}
	}

class RunButton extends JButton implements ActionListener {
	private Container cont;
	public RunButton(String s, Container c) {
		super(s);
		cont = c;  // フレームの情報を取得
		addActionListener(this);  // ボタンのイベントを有効にする

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 部品を動かす
		CharaThread charaThread = new CharaThread(cont);
		charaThread.start();
		// スレッドリストに設定する
		threadList.add(charaThread);
	}
}

	class CharaThread extends Thread implements Runnable {
		private Container cont;
		private int moveX;// 移動距離（いどうきょり）
		private int sleepTime;
		private Point point = new Point(0, 0);
		private Image[] images = new Image[2];
		private int runCount = 0; // カウンタ

		public CharaThread(Container c) {
			super();
			cont = c;

			moveX = 30; //　移動距離（いどうきょり）を決める
			// 移動速度（いどうそくど）をランダムに決める
			sleepTime = (int) (4 * Math.random() + 2) * 100;
			// Yの位置（いち）をランダムに決める
			int y = (int) ((cont.getSize().height - 30) * Math.random());
			point.setLocation(point.getX(), y);

			// 画像情報（がぞうじょうほう）
			ImageIcon icon = new ImageIcon("src/img/img3/imomushiR01.png");
			images[0] = icon.getImage();
			icon = new ImageIcon("src/img/img3/imomushiiR02.png");
			images[1] = icon.getImage();
		}

		//使用する画像を決めるメソッド
		public Image getImage() {
			return images[runCount % 2];
		}

		//　画像の位置情報を取得するために利用るする
	public  Point	getPoint() {
		return point;
	}

		@Override
		public void run() {
			// 無限にループさせる
			while (true) {
				try {
					sleep(sleepTime);
				} catch (Exception e) {
					// 処理なし
				}
				//Xの位置を決める
				point.x += moveX;

				runCount++;
				cont.repaint();
			}
		}
	}
}
