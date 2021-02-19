package Swing_8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
// モグラが移動するスレッド追加から
public class JFrameGameEx1_2 extends JFrame {
	JFrameGameEx1_2() {
		setSize(800, 600);
		setTitle("モグラたたき_2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GamePanel panel = new GamePanel();
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameGameEx1_2();
		frame.setVisible(true);
	}
//
	class GamePanel extends JPanel {
//		private String message = null;
		private int x = 50; //　カーソル X座標
		private int y = 70; // 　カーソル Y座標

		private int hammerX =0; //ハンマーX座標
		private int hammerY =0; //ハンマーY座標

		private Image[] imgHammers = new Image[2]; //ハンマーの画像
		private int idxHammer=0;  // ハンマーの画像のインデックス

		private int moguX = 100; // モグラのX座標
		private int moguY = 100; // モグラのY座標

		private Image[] imgMogus = new Image[2]; //ハンマーの画像
		private int idxMogu=0;  // ハンマーの画像のインデックス

		private int respawnMogu = 0;  // モグラが出現するまでの時間

		public GamePanel() {
			//　マウスイベントを有効化する
			GameMouseAdapter adapter = new GameMouseAdapter();
			addMouseListener(adapter);
			addMouseMotionListener(adapter);

			//画像設定（がぞうせってい）
			ImageIcon icon = new ImageIcon("src/mouseGame/img/PHA00.gif");
			imgHammers[0] = icon.getImage();
			icon = new ImageIcon("src/mouseGame/img/PHA01.gif");
			imgHammers[1] = icon.getImage();

			icon = new ImageIcon("src/mouseGame/img/M00.gif");
			imgMogus[0] = icon.getImage();
			icon = new ImageIcon("src/mouseGame/img/M01.gif");
			imgMogus[1] = icon.getImage();

			// ゲームの時間を動かす
			MoguThread moguthread = new MoguThread();
			moguthread.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.BLACK);
			//メッセージが設定されていた場合
//			if (message != null) {
//				g.setColor(Color.YELLOW);
//				g.drawString(message, x, y);
//			}
			g.drawImage(imgMogus[idxMogu], moguX, moguY, 100, 100, this);

			g.drawImage(imgHammers[idxHammer], hammerX, hammerY, 100, 100, this);
		}

		class MoguThread extends Thread implements Runnable {
			public MoguThread() {
				super();
			}
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(16);
					} catch(InterruptedException e) {

					}
					// モグラを出現させる処理（出現時間の調整）
					if(respawnMogu != 0) {
						respawnMogu--;
						if(respawnMogu == 0){
							idxMogu = 0;
							//モグラの出現位置（しゅつげんいち）をランダムにセット
							moguX = (int)(Math.random() * 550);
							moguY = (int)(Math.random() * 450);
						}
						repaint();
					}
				}
			}
		}

		/** マウスイベントを管理するクラス */
		class GameMouseAdapter extends MouseAdapter {
			/** マウスがおされた　　*/
			@Override
			public void mousePressed(MouseEvent me) {
//				message = "マウスがおされたよ！";
				idxHammer = 1; //
//				// カーソルの位置（いち）を取得（しゅとく）
//				x = me.getX();
//				y = me.getY();
				// ハンマーの位置（いち）の取得k（しゅとく）
				hammerX = me.getX()-x;
				hammerY = me.getY() -y;

				//あたりの判定（はんてい）　もぐら画像の指定
				if(hammerX >moguX - 50 && hammerX < moguX+90
						&& hammerY > moguY -70 && hammerY < moguY +60) {
					// 当たった場合
					idxMogu = 1;
					respawnMogu = 30;
//				}else {
//					// 当たらなかった場合
//					idxMogu = 0;
				}
				repaint(); //　再描画
			}

			/** マウスがはなされた*/
			@Override
			public void mouseReleased(MouseEvent me) {
//				message = "マウスがはなされたよ！";
				idxHammer = 0; //
//				// カーソルの位置（いち）を取得（しゅとく）
//				x = me.getX();
//				y = me.getY();
				// ハンマーの位置（いち）の取得k（しゅとく）
				hammerX = me.getX()-x;
				hammerY = me.getY() -y;

//				idxMogu = 0; // モグラ画像の指定（してい）
//				repaint(); //　再描画
			}

//			/** マウスがクリックされた*/
//			@Override
//			public void mouseClicked(MouseEvent me) {
//				message = "マウスがクリックされたよ！";
//				// カーソルの位置（いち）を取得（しゅとく）
//				x = me.getX();
//				y = me.getY();
//				repaint(); //　再描画
//			}

			/** マウスを動かした*/
			@Override
			public void mouseMoved(MouseEvent me) {
//				message = "マウスを移動したよ！";
//				// カーソルの位置（いち）を取得（しゅとく）
//				x = me.getX();
//				y = me.getY();
				// ハンマーの位置（いち）の取得k（しゅとく）
				hammerX = me.getX()-x;
				hammerY = me.getY() -y;

//				repaint(); //　再描画
			}

			/** マウスをドラッグした*/
			@Override
			public void mouseDragged(MouseEvent me) {
//				message = "マウスをドラッグたよ！";
//				// カーソルの位置（いち）を取得（しゅとく）
//				x = me.getX();
//				y = me.getY();
				// ハンマーの位置（いち）の取得k（しゅとく）
				hammerX = me.getX()-x;
				hammerY = me.getY() -y;
//				repaint(); //　再描画
			}
		}
	}
}
