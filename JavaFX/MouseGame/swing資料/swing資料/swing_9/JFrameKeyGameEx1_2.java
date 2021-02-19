package swing_9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 隕石と背景 */
public class JFrameKeyGameEx1_2 extends JFrame {
	public JFrameKeyGameEx1_2() {
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
		JFrame frame = new JFrameKeyGameEx1_2();
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

		/** 背景（はいけい）１の位置　*/
		private int backgroundY1 = 0;
		/** 背景（はいけい）2の位置　*/
		private int backgroundY2 = 0;

		/**　隕石（いんぜき）の最大表示数（さいだいひょうじすう） */
		private int maxMeteors = 100;
		/** 隕石（いんせき）の初期位置（しょきいち）　*/
		private int meteorStartY = -9999;

		/** 隕石（いんせき）の位置　*/
		private int[] meteorsX = new int[maxMeteors];
		private int[] meteorsY = new int[maxMeteors];
		/** 隕石（いんせき）の速度　*/
		private int[] spMeteorsX = new int[maxMeteors];
		private int[] spMeteorsY = new int[maxMeteors];
		/** 隕石（いんせき）の大きさ*/
		private int[] meteorsSize = new int[maxMeteors];
		/** 背景１の画像 */
		private Image imageBackground1 = null;
		/** 背景2の画像 */
		private Image imageBackground2 = null;
		/**隕石の画像 */
		private Image imageMeteor = null;

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
			icon = new ImageIcon("src/kBGame/img/imageShipL.gif");
			imageShips[2] = icon.getImage();
			//背景１の画像を読み込む
			icon = new ImageIcon("src/kBGame/img/imageBackground1.gif");
			imageBackground1 = icon.getImage();
			//背景2の画像を読み込む
			icon = new ImageIcon("src/kBGame/img/imageBackground2.gif");
			imageBackground2 = icon.getImage();

			//隕石の画像を読み国
			icon = new ImageIcon("src/kBGame/img/imageMeteor.gif");
			imageMeteor = icon.getImage();
			//ゲームを動かす
			ShootingThread thread = new ShootingThread();
			thread.start();

			// 初期化処理
			init();
		}
		/**初期化処理（しょきかしょり）　*/
		private void init() {
			gameTime = 0;
			// 宇宙船の初期位置（いち）
			shipX = 384;
			shipY = 640;

			//隕石の初期化
			for (int i = 0; i < maxMeteors; i++) {
				meteorsY[i] = meteorStartY;
			}

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 背景１を描画する

			g.drawImage(imageBackground1, 0, backgroundY1, 800, 800, this);
			g.drawImage(imageBackground1, 0, backgroundY1 + 800, 800, 800, this);
			// 背景2を描画する
			g.drawImage(imageBackground2, 0, backgroundY2, 800, 800, this);
			g.drawImage(imageBackground2, 0, backgroundY2 + 800, 800, 800, this);
			// 隕石を描画する
			for (int i = 0; i < maxMeteors; i++) {
				if (meteorsY[i] != meteorStartY) {
					g.drawImage(imageMeteor, meteorsX[i], meteorsY[i], meteorsSize[i], meteorsSize[i], this);
//					System.out.println(meteorsX[i]+"  "+ meteorsY[i]+"  "+meteorsSize[i]);
				}
			}
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
					// 	背景１移動タイミング
					if (gameTime % 5 == 0) {
						backgroundY1++;
						if (backgroundY1 > 0) {
							backgroundY1 = -800;
						}
					}
					// 	背景2移動タイミング
					if (gameTime % 2 == 0) {
						backgroundY2++;
						if (backgroundY2 > 0) {
							backgroundY2 = -800;
						}
					}
					// キー入力を受け付けるタイミング　　宇宙船移動（うちゅうせんいどう）タイミング
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
					//宇宙船移動（うちゅうせんいどう）タイミング
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
						//隕石の作成速度（さくせいそくど）をランダムにする
						if (Math.random() < 0.03) {
							// 位置が初期化された隕石を選択
							int idxMeteors = -1;
							for (int i = 0; i < maxMeteors; i++) {
								if (meteorsY[i] == meteorStartY) {
									idxMeteors = i;
									break;
								}
							}
							// 隕石を初期化
							/**　隕石のサイズ　　*/
							meteorsSize[idxMeteors] = (int) (Math.random() * 200);
							/** 隕石発生地点　X　　*/
							meteorsX[idxMeteors] = (int) (Math.random() * 800);
							/** 隕石発生地点　Y　　*/
							meteorsY[idxMeteors] = -meteorsSize[idxMeteors];
							/**　隕石速度　X		*/
							spMeteorsX[idxMeteors] = 3 - (int) (Math.random()*6);
							/**　隕石速度　Y		*/
							spMeteorsY[idxMeteors] = (int) (Math.random()*15);

						}
						for (int i = 0; i < maxMeteors; i++) {
							// 隕石が初期位置以外であれば、移動させる
							if (meteorsY[i] != meteorStartY) {
								meteorsX[i] += spMeteorsX[i];
								meteorsY[i] += spMeteorsY[i];
								// 隕石が下まで到達したら、初期位置に戻す
								if (meteorsY[i] > 800) {
									meteorsY[i] = meteorStartY;
								}
							}
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

