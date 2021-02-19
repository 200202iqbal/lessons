package Swing_8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGameEx1 extends JFrame {
	JFrameGameEx1() {
		setSize(800, 600);
		setTitle("モグラたたき");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GamePanel panel = new GamePanel();
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameGameEx1();
		frame.setVisible(true);
	}

	class GamePanel extends JPanel {
//		private String message = null;
		private int x = 0; // X座標
		private int y = 0; // Y座標

		private Image[] imgHammers = new Image[2]; //ハンマーの画像
		private int idxHammer=0;  // ハンマーの画像のインデックス

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
			g.drawImage(imgHammers[idxHammer], x, y, 100, 100, this);
		}

		/** マウスイベントを管理するクラス */
		class GameMouseAdapter extends MouseAdapter {
			/** マウスがおされた　　*/
			@Override
			public void mousePressed(MouseEvent me) {
//				message = "マウスがおされたよ！";
				idxHammer = 1; //
				// カーソルの位置（いち）を取得（しゅとく）
				x = me.getX();
				y = me.getY();
				repaint(); //　再描画
			}

			/** マウスがはなされた*/
			@Override
			public void mouseReleased(MouseEvent me) {
//				message = "マウスがはなされたよ！";
				idxHammer = 0; //
				// カーソルの位置（いち）を取得（しゅとく）
				x = me.getX();
				y = me.getY();
				repaint(); //　再描画
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
				// カーソルの位置（いち）を取得（しゅとく）
				x = me.getX();
				y = me.getY();
				repaint(); //　再描画
			}

			/** マウスをドラッグした*/
			@Override
			public void mouseDragged(MouseEvent me) {
//				message = "マウスをドラッグたよ！";
				// カーソルの位置（いち）を取得（しゅとく）
				x = me.getX();
				y = me.getY();
				repaint(); //　再描画
			}
		}
	}
}
