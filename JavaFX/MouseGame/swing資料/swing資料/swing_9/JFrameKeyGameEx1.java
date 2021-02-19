package swing_9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/** 宇宙船の登場まで */
public class JFrameKeyGameEx1 extends JFrame {
	public JFrameKeyGameEx1() {
		setTitle("シューティング");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// キーイベントを有効化する
		ShootingKeyAdapter adapter = new ShootingKeyAdapter();
		addKeyListener(adapter);

		ShootingPanel1 panel = new ShootingPanel1(adapter);
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameKeyGameEx1();
		frame.setVisible(true);
	}

	public class ShootingPanel1 extends JPanel {
		/** 宇宙船（うちゅうせん）の位置（いち） */
		private int shipX = 0;
		private int shipY = 0;
		/** 速度（そくど）*/
		private int spShipX = 0; // ｘ方向の速度
		/**　宇宙船の画像（がぞう）*/
		private Image[] imageShips = new Image[3];
		/** 宇宙船の向（む）き　*/
		private int direction = 0; // 0:正面　1:右　２:左
		/** 経過時間（けいかじかん）*/
		private int gameTime = 0;

		/** キーイベント情報（じょうほう）を保存（ほぞん）する　*/
		ShootingKeyAdapter adapter;

		public ShootingPanel1(ShootingKeyAdapter adapter) {
			this.adapter = adapter; //キーイベント情報を保存（ほぞん）する

			setBackground(Color.BLACK);

			// 宇宙船の画像（がぞう）を読み込み
			ImageIcon icon = new ImageIcon("src/kBGame/img/imageShip0.gif");
			imageShips[0] = icon.getImage();
			icon = new ImageIcon("src/kBGame/img/imageShipR.gif");
			imageShips[1] = icon.getImage();
			icon = new ImageIcon("src/kBGame//img/imageShipL.gif");
			imageShips[2] = icon.getImage();

			//ゲームを動かす
			ShootingThread thread = new ShootingThread();
			thread.start();

			// 初期化処理
			init();
		}

		private void init() {
			gameTime = 0;
			// 宇宙船の初期位置（いち）
			shipX = 384;
			shipY = 640;

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 宇宙船を描画（びょうが）する
			g.drawImage(imageShips[direction], shipX, shipY, 32, 40, this);
		}

		class ShootingThread extends Thread implements Runnable {
			public ShootingThread() {
				super();
			}

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {

					}
					gameTime++; //　時間+１
					// 宇宙船移動（うちゅうせんいどう）タイミング
					if (gameTime % 6 == 0) {
						// 向きを初期化
						direction = 0;
						// 左の場合（ひだりのばあい）
						if (adapter.isKeyCodePressed(KeyEvent.VK_LEFT)) {
							direction = 2; // 画像を左向（ひだりむ）きにする
							spShipX -= 1; // 加速（かそく）する
						}
						if (adapter.isKeyCodePressed(KeyEvent.VK_RIGHT)) {
							direction = 1; // 画像を右向（みぎむ）きにする
							spShipX += 1; // 加速（かそく）する
						}
					}
					//宇宙船移動（うちゅうせにどう）タイミング
					if (gameTime % 2 == 0) {
						shipX += spShipX; //宇宙船の移動
						//画面の左の来た時、宇宙船を止める
						if (shipX < 0) {
							shipX = 0;
							spShipX = 0;
						} else if (shipX > getWidth() - 32) {
							shipX = getWidth() - 32;
							spShipX = 0;
						}
					} else {
						repaint(); // 再描画
					}
				}
			}
		}
	}
	/***** キーアダプタークラス　　*/
	class ShootingKeyAdapter extends KeyAdapter {
		boolean[] keyPressTbl = new boolean[256];

		/** キーを押されたときによばれます **/
		@Override
		public void keyPressed(KeyEvent ke) {
			int code = ke.getKeyCode();
			if (code < 256) {
				keyPressTbl[code] = true;
			}
		}
			/**  キーを離したときよばれます **/
		@Override
		public void keyReleased(KeyEvent ke) {
			int code = ke.getKeyCode();
			if (code < 256) {
				keyPressTbl[code] = false;
			}
		}

		/** キー押下中かどうかをチェック */
		public boolean isKeyCodePressed(int keyCode) {
			return keyPressTbl[keyCode];
		}
	}
}

