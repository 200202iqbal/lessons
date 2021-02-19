package Swing7;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameThreadEx3 extends JFrame {
	public JFrameThreadEx3() {
		setSize(400, 300);
		setTitle("画像の移動");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		ThreadPanel3 panel = new ThreadPanel3();
		cont.add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameThreadEx3();
		frame.setVisible(true);
	}

	class ThreadPanel3 extends JPanel {
		FishThread thread = null;

		public ThreadPanel3() {
			setBackground(Color.CYAN);
			// 部品を動かす
			thread = new FishThread(this, 5, 40);
			thread.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 画像（がぞう）を作成（さくせい）する
			g.drawImage(thread.getImage(), thread.getPoint().x, thread.getPoint().y,
					thread.imageSize.width, thread.imageSize.height, this);
		}
	}

	class FishThread extends Thread implements Runnable {
		private Container cont;
		private int directionX; // Xへの移動方向（いどうほうこう）
		private int sleepTime; // 移動速度（いどうそくど）
		private Point point = new Point(0, 100);
		private Dimension imageSize = new Dimension(100, 79);

		private Image[] fishImages = new Image[2];
		private int idxLR = 0;

		public FishThread(Container c, int move, int time) {
			super();
			cont = c;

			directionX = move; // Xの移動する方向を決める　←　→
			sleepTime = time;

			// 画像情報（がぞうじょうほう）を設定（せってい）する
			ImageIcon icon = new ImageIcon("src/img/img2/fish04R.png");
			fishImages[0] = icon.getImage();
			icon = new ImageIcon("src/img/img2/fish04L.png");
			fishImages[1] = icon.getImage();
		}

		//使用する画像を決めるメソッド
		public Image getImage() {
			return fishImages[idxLR];
		}

		// 画像（がぞう）の位置情報（いちじょうほう）を取得（しゅとく）するために利用する
		public Point getPoint() {
			return point;
		}

		/**　部品を動かすメソッド*/
		@Override
		public void run() {
			//無限ループ
			while (true) {
				try {
					Thread.sleep(sleepTime);
				} catch (Exception e) {
					//処理なし
				}

				// Xの移動する方向を決める
				point.x += directionX;

				// 画像の右に来たら符号を反転する
				if (point.x + imageSize.width > cont.getSize().width) {
					idxLR = 1; // 画像反転（がぞうはんてん）
					directionX *= -1;
				}
				// 画像の右に来たら符号を反転する
				if (point.x < 0) {
					idxLR = 0; // 画像反転（がぞうはんてん）
					directionX *= -1;
				}
				cont.repaint();
			}
		}
	}
}
