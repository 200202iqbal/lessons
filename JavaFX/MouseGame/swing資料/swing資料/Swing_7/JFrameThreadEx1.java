package Swing7;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameThreadEx1 extends JFrame implements Runnable {
	int ballX, ballY; // ボールの始点座標（してんざひょう）
	int width, height; //　ボールの幅、高さ
	int panelWidth, panelHeight; // パネルのサイズ（幅、高さ）
	int directionX, directionY; //　XとYの移動方向（いどうほうこう）

	public JFrameThreadEx1() {
		setSize(400, 300);
		setTitle("スレッドのテスト");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//ボールの初期位置（しょきいち）を決める
		ballX = 100;
		ballY = 100;
		//ボールのサイズを決める
		width = 20;
		height = 20;
		//ボールの移動方向（いどうほうこう）をきめる
		directionX = 1; // x方向(1:→ 1: ←)
		directionY = 1; // ｙ方向(1:↓ 1: ↑)

		Container cont = getContentPane();
		ThreadPanel1 panel = new ThreadPanel1();
		cont.add(panel);

		// ボールを動かす  // 一つの物体（ぶったい）に動き（うごき）をあたえる処理（しょり）
		Thread thread = new Thread(this);
		thread.start();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameThreadEx1();
		frame.setVisible(true);
	}

	/**  部品(ぶひん）を動（うご）かすメソッド */
	@Override
	public void run() {
			// 移動距離（いどうきょり）を決）き）める
		int moveX = 2;
		int moveY =  2;

		// 無限（むげん）ループさせる
		while(true) {
			// 移動速度（いどうそくど）をきめる　
			try {
				Thread.sleep(20); // スレッドのスリープ時間を20msに
			}catch(Exception e) {
				// 処理はなし
			}
			// X、Yの移動する方向を決める
			ballX += moveX*directionX;
			ballY += moveY*directionY;
			//　画面の左or右の端（はし）に来たら符号（ふごう）を反転（はんてん）させる
			if(ballX <0 ||ballX > panelWidth-width) {
				directionX *= -1;
			}
			if(ballY < 0 ||ballY >panelHeight - height) {
				directionY *= -1;
			}
			repaint();
		}
	}
	class ThreadPanel1 extends JPanel {
		public ThreadPanel1() {
			setBackground(Color.PINK);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		   // パネルの幅と高（はばとたか）さを取得（しゅとく）する
			Dimension d = getSize();
			panelWidth= d.width;
			panelHeight = d.height;

			// ボールを作成する
			g.setColor(Color.BLUE);
			g.fillOval(ballX, ballY, width, height);
		}
	}

}
