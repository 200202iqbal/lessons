import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameKeyGameTest3 extends JFrame {
	public JFrameKeyGameTest3() {
		setTitle("シューティング");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// キーイベントを有効化する
		ShootingKeyAdapterTest3 adapter = new ShootingKeyAdapterTest3();
		addKeyListener(adapter);

		ShootingPanelTest3 panel = new ShootingPanelTest3(adapter);
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameKeyGameTest3();
		frame.setVisible(true);
	}
}

class ShootingPanelTest3 extends JPanel {
	/** 宇宙船(うちゅうせん)位置(いち) */
	private int shipX = 0; //X座標
	private int shipY = 0; //Y座標
	/** 速度(そくど) */
	private int spShipX = 0; //X方向の速度
	private int spShipY = 0; //Y方向の速度
	/** 宇宙船の画像(がぞう) */
	private Image[] imageShips = new Image[3];
	/** 宇宙船の向(む)き */
	private int direction = 0; //0：正面, 1：右, 2：左
	/** 経過時間(けいかじかん) */
	private int gameTime = 0;

	/** 背景１の位置 */
	private int backgroundY1 = 0;
	/** 背景２の位置 */
	private int backgroundY2 = 0;

	/** 隕石(いんせき)の最大表示数 */
	private int maxMeteors = 100;
	/** 隕石(いんせき)の初期位置 */
	private int meteorStartY = -9999;

	/** 隕石(いんせき)の位置 */
	private int[] meteorsX = new int[maxMeteors];
	private int[] meteorsY = new int[maxMeteors];
	/** 隕石の速度 */
	private int[] spMeteorsX = new int[maxMeteors];
	private int[] spMeteorsY = new int[maxMeteors];
	/** 隕石の大きさ */
	private int[] meteorsSize = new int[maxMeteors];
	/** 背景１の画像 */
	private Image imageBackground1 = null;
	/** 背景２の画像 */
	private Image imageBackground2 = null;
	/** 隕石の画像 */
	private Image imageMeteor = null;

	/** 隕石の角度(かくど) */
	private int[] angleMeteors = new int[maxMeteors];
	private int[] velocityMeteors = new int[maxMeteors];

	private final Font FONT_TEXT = new Font("MS ゴシック", Font.PLAIN, 16);
	private final Font FONT_GAMEOVER = new Font("MS ゴシック", Font.BOLD, 24);

	private int phase = 0;//フェーズ
	private int score = 0; //得点(とくてん)
	private int scoreHigh = 30000; //最高得点(さいこうとくてん)
	private int interval = 0;//インターバル

	/** ゲームの状態(じょうたい) */
	private final int PHASE_GAME = 0;
	private final int PHASE_CLASH = 1;
	private final int PHASE_GAMEOVER = 2;

	private KSoundMidi waveSpace = null; //BGM
	private KSoundWave waveGetReady = null; //効果音(こうかおん)①
	private KSoundWave waveClash = null; //効果音(こうかおん)②
	private KSoundWave waveGameOver = null; //効果音(こうかおん)③

	//↓↓↓↓↓↓↓
	private int gameCount = 0;//何回目(なんかいめ)のゲーム？
	//↑↑↑↑↑↑↑


	/** キーイベント情報を保存する */
	ShootingKeyAdapterTest3 adapter;

	public ShootingPanelTest3(ShootingKeyAdapterTest3 adapter) {
		this.adapter = adapter; //キーイベント情報を保存(ほぞん)する

		setBackground(Color.BLACK);

		//宇宙船の画像(がぞう)を読み込む
		ImageIcon icon = new ImageIcon("src/img/imageShip0.gif");
		imageShips[0] = icon.getImage();
		icon = new ImageIcon("src/img/imageShipR.gif");
		imageShips[1] = icon.getImage();
		icon = new ImageIcon("src/img/imageShipL.gif");
		imageShips[2] = icon.getImage();
		//背景１の画像(がぞう)を読み込む
		icon = new ImageIcon("src/img/imageBackground1.gif");
		imageBackground1 = icon.getImage();
		//背景２の画像(がぞう)を読み込む
		icon = new ImageIcon("src/img/imageBackground2.gif");
		imageBackground2 = icon.getImage();

		//隕石の画像(がぞう)を読み込む
		icon = new ImageIcon("src/img/imageMeteor.gif");
		imageMeteor = icon.getImage();

		waveSpace = new KSoundMidi(this, "sound/midiGame.mid", false);
		waveGetReady = new KSoundWave(this, "sound/waveGetReady.wav", false);
		waveClash = new KSoundWave(this, "sound/waveClash.wav", false);
		waveGameOver = new KSoundWave(this, "sound/waveGameOver.wav", false);

		//ゲームを動かす
		ShootingThread thread = new ShootingThread();
		thread.start();

		//初期化処理
		init();
	}

	/** 初期化処理(しょきかしょり) */
	public void init() {
// ↓↓↓↓↓↓↓↓↓↓↓↓
		if (gameCount == 3) {
			gameCount = 0; //ゲームカウントをクリア
		}

		gameCount++;
		System.out.println("gameCount:" + gameCount);

		if (gameCount == 1) {
			score = 0; //得点を0点にする
		}
// ↑↑↑↑↑↑↑↑↑↑↑↑

		phase = PHASE_GAME;//フェーズをゲーム中にする

		gameTime = 0; //ゲームの時間
		interval = 0; //インターバルを管理

		//宇宙船の初期位置(しょきいち)
		shipX = 384;
		shipY = 640;

		//隕石の初期化
		for (int i = 0; i < maxMeteors; i++) {
			meteorsY[i] = meteorStartY;
		}
		waveSpace.init();
		waveSpace.start();
		waveGetReady.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//画像を回転(かいてん)させるための処理
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform af = new AffineTransform();

		// 背景1を描画する
		g.drawImage(imageBackground1, 0, backgroundY1, 800, 800, this);
		g.drawImage(imageBackground1, 0, backgroundY1 + 800, 800, 800, this);

		// 背景2を描画する
		g.drawImage(imageBackground2, 0, backgroundY2, 800, 800, this);
		g.drawImage(imageBackground2, 0, backgroundY2 + 800, 800, 800, this);

		// 隕石を描画する
		for (int i = 0; i < maxMeteors; i++) {
			if (meteorsY[i] != meteorStartY) {
				// 回転速度（かいてんそくど）と回転の中心座標（X,Y）を決める
				double radius = angleMeteors[i] * Math.PI / 180;
				double meteorX = (double) meteorsX[i] + meteorsSize[i] / 2;
				double meteorY = (double) meteorsY[i] + meteorsSize[i] / 2;

				//画像を回転(かいてん)させるための処理
				af.setToRotation(radius, meteorX, meteorY);
				g2.setTransform(af);

				g2.drawImage(imageMeteor, meteorsX[i], meteorsY[i], meteorsSize[i], meteorsSize[i], this);
			}
		}
		//画像を回転(かいてん)させるための処理
		af.setToRotation(0d, 0d, 0d);
		g2.setTransform(af);

		// 宇宙船を描画する
		g2.drawImage(imageShips[direction], shipX, shipY, 32, 40, this);

		// スコアを描画する
		g2.setColor(Color.LIGHT_GRAY);
		g2.setFont(FONT_TEXT);
		g2.drawString("SCORE　" + score, 100, 20);
		g2.drawString("HIGH-SCORE　" + scoreHigh, 500, 20);

		// ゲーム終了時(しゅうりょうじ)に描画する
		if (phase == PHASE_GAMEOVER) {
			g2.setFont(FONT_GAMEOVER);

			//↓↓↓↓↓↓↓
			if (gameCount == 3) {
				g2.drawString("GAME OVER", 300, 350);
			} else {
				g2.drawString("CONTINUE", 300, 350);
			}
			//↑↑↑↑↑↑↑
		}
	}

	class ShootingThread extends Thread implements Runnable {
		public ShootingThread() {
			super();
		}

		public void run() {
			while (true) {
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {

				}
				gameTime++;

				//背景１移動タイミング
				if (gameTime % 5 == 0) {
					backgroundY1++;
					if (backgroundY1 > 0) {
						backgroundY1 = -800;
					}
				}
				//背景２移動タイミング
				if (gameTime % 2 == 0) {
					backgroundY2++;
					if (backgroundY2 > 0) {
						backgroundY2 = -800;
					}
				}
				// キー入力を受けつけるタイミング
				if (gameTime % 6 == 0) {
					// 向きを初期化
					direction = 0;
					if (phase == PHASE_GAME) {
						// 左の場合（ひだりのばあい）
						if (adapter.isKeyCodePressed(KeyEvent.VK_LEFT)) {
//							System.out.println("←");
							direction = 2; //画像を左向(ひだりむ)きにする
							spShipX -= 1; // 加速(かそく)する
						}
						if (adapter.isKeyCodePressed(KeyEvent.VK_RIGHT)) {
//							System.out.println("→");
							direction = 1; //画像を右向(みぎむ)きにする
							spShipX += 1; // 加速する
						}
						//　↑
						if (adapter.isKeyCodePressed(KeyEvent.VK_UP)) {
//							System.out.println("↑");
							spShipY -= 1; // 加速する

						}
						//　↓
						if (adapter.isKeyCodePressed(KeyEvent.VK_DOWN)) {
//							System.out.println("↓");
							spShipY += 1; // 加速する
						}
					}
				}
				// 宇宙船移動(うちゅうせんいどう)タイミング
				if (gameTime % 2 == 0) {

					//ゲーム中
					if (phase == PHASE_GAME) {
						//ゲーム中のスコアカウント
						score += 10;
						//ハイスコア更新(こうしん)で上書き
						if (score > scoreHigh) {
							scoreHigh = score;
						}
					}
					//クラッシュ(当たり判定発生時)
					else if (phase == PHASE_CLASH) {
						interval++;
						shipX += spShipX;
						shipY += spShipY;

						if (interval == 1) {
							waveClash.start();
						}

						if (interval == 120) {
							phase = PHASE_GAMEOVER;
							waveGameOver.start();
						}
					}
					//ゲームオーバー
					else if (phase == PHASE_GAMEOVER) {
						interval++;
						if (interval == 420) {
							init();
						}
					}

					shipX += spShipX; //宇宙船の移動
					shipY += spShipY; //宇宙船の移動

					if (phase == PHASE_GAME) {
						// 一番左に来た場合、宇宙船を止める
						if (shipX < 0) {
							shipX = 0;
							spShipX = 0;
							// 一番右に来た場合、宇宙船を止める
						} else if (shipX > getWidth() - 32) {
							if (getWidth()> 0) {
								shipX = getWidth() - 32;
								spShipX = 0;
							}
						}
						if (shipY < 0) {
							shipY = 0;
							spShipY = 0;
							// 一番右に来た場合、宇宙船を止める
						} else if (shipY > getHeight() - 40) {
							if (getHeight()> 0) {
								shipY = getHeight() - 40;
								spShipY = 0;
							}
						}
//						System.out.println(getWidth() + ", " + getHeight());
					}


					//　隕石の作成速度にランダム性を持たせる
					if (Math.random() < 0.03) {
						// 位置が初期化された隕石を探す
						int idxMeteors = -1;
						for (int i = 0; i < maxMeteors; i++) {
							if (meteorsY[i] == meteorStartY) {
								idxMeteors = i;
								break;
							}
						}
						// 隕石を初期化
						/** 隕石のサイズ */
						meteorsSize[idxMeteors] = (int) (Math.random() * 200);
						/** 隕石発生地点：X */
						meteorsX[idxMeteors] = (int) (Math.random() * 800);
						/** 隕石発生地点：Y */
						meteorsY[idxMeteors] = -meteorsSize[idxMeteors];
						/** 隕石速度：X */
						spMeteorsX[idxMeteors] =  3 - (int) (Math.random() * 6);
						/** 隕石速度：Y */
						spMeteorsY[idxMeteors] =  (int) (Math.random() * 15);

						/** 隕石を回転させる */
						angleMeteors[idxMeteors] = (int) (Math.random() * 360);
						velocityMeteors[idxMeteors] = (int) (Math.random() * 10);
					}
					for (int i = 0; i < maxMeteors; i++) {
						//隕石が初期位置以外であれば移動させる
						if (meteorsY[i] != meteorStartY) {
							meteorsX[i] += spMeteorsX[i];
							meteorsY[i] += spMeteorsY[i];

							//隕石に回転角度をつける
							angleMeteors[i] += velocityMeteors[i];

							//隕石と宇宙船の当たり判定
							if (meteorsX[i] < shipX + 10 && shipX + 32 - 10 < meteorsX[i] + meteorsSize[i] &&
									meteorsY[i] < shipY + 20 && shipY + 40 - 20 < meteorsY[i] + meteorsSize[i]) {
								spShipX = spMeteorsX[i];
								spShipY = spMeteorsY[i];

								phase = PHASE_CLASH;
							}

							///隕石が下まで到達(とうたつ)したら初期位置に戻す
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

/*** キーアダプタークラス ***/
class ShootingKeyAdapterTest3 extends KeyAdapter {
	boolean[] keyPressTbl = new boolean[256];

	/*** キーを押されたときに呼ばれます ***/
	public void keyPressed(KeyEvent ke) {
		int code = ke.getKeyCode();
		if (code < 256) {
			keyPressTbl[code] = true;
		}
	}

	/*** キーを離したときに呼ばれます ***/
	public void keyReleased(KeyEvent ke) {
		int code = ke.getKeyCode();
		if (code < 256) {
			keyPressTbl[code] = false;
		}
	}

	/*** キー押下中かどうかをチェック ***/
	public boolean isKeyCodePressed(int keyCode) {
		return keyPressTbl[keyCode];
	}
}
