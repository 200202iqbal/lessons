package example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class JFrameGameExTest2 extends JFrame {
	public JFrameGameExTest2() {
		setSize(800, 600);
		setTitle("モグラたたき");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GamePanelExTest2 panel = new GamePanelExTest2();
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameGameExTest2();
		frame.setVisible(true);
	}
}

class GamePanelExTest2 extends JPanel {
	private int x = 50; //カーソル：X座標
	private int y = 70; //カーソル：Y座標

	private int hummerX = 0; //ハンマー：X座標
	private int hummerY = 0; //ハンマー：Y座標

	private Image[] imgHammers = new Image[2]; //ハンマーの画像
	private int idxHummer = 0; //ハンマー画像のindex

	private int moguX = 100; //モグラ：X座標
	private int moguY = 100; //モグラ：Y座標
	private int moguX2 = 100; //モグラ：X座標  /*Question5*/
	private int moguY2 = 100; //モグラ：Y座標  /*Question5*/

	private Image[] imgMogus = new Image[2]; //モグラの画像
	private int idxMogu = 0; //モグラ画像のindex
	private int idxMogu2 = 0; //モグラ画像のindex  /*Question5*/

	private int respawnMogu = 0; //モグラの出現までの時間
	private int respawnMogu2 = 0; //モグラの出現までの時間  /*Question5*/

	private Image imageBackground = null; //背景画像(はいけいがぞう)

	private int phase = 0; //フェーズ
	private int score = 0; //得点
	private int gameTime = 0; //残り時間

	private Font fontBase = new Font("ＭＳ ゴシック", Font.BOLD | Font.ITALIC, 24);
	private Font fontGameOver = new Font("ＭＳ ゴシック", Font.BOLD | Font.ITALIC, 48);

	private KSoundMidi midiMoguraDance = null; //BGM
	private KSoundWave waveMoguraDeru = null; //効果音(こうかおん)①
	private KSoundWave wavePikoHammerMiss = null; //効果音(こうかおん)②
	private KSoundWave wavePikoHammerHit = null; //効果音(こうかおん)③

	public GamePanelExTest2() {
			// マウスイベントを有効化する
			GameMouseAdapter adapter = new GameMouseAdapter();
			addMouseListener(adapter);
			addMouseMotionListener(adapter);

			//画像設定(がぞうせってい)
			ImageIcon icon = new ImageIcon("src/img/PHA00.gif");
			imgHammers[0] = icon.getImage();
			icon = new ImageIcon("src/img/PHA01.gif");
			imgHammers[1] = icon.getImage();

			icon = new ImageIcon("src/img/M00.gif");
			imgMogus[0] = icon.getImage();
			icon = new ImageIcon("src/img/M01.gif");
			imgMogus[1] = icon.getImage();

			icon = new ImageIcon("src/img/Background.jpg");
			imageBackground = icon.getImage();

			//ゲームの時間を動かす
			MoguThread moguThread = new MoguThread();
			moguThread.start();

			/*Question5*/
			MoguThread1 moguThread1 = new MoguThread1();
			moguThread1.start();

			// BGMを設定する
			midiMoguraDance = new KSoundMidi(this, "../sound/MoguraDance.mid", false);
			// 効果音を設定する
			waveMoguraDeru = new KSoundWave(this, "../sound/MoguraDeru.wav", false);
			wavePikoHammerMiss = new KSoundWave(this, "../sound/PicoHammerMiss.wav", false);
			wavePikoHammerHit = new KSoundWave(this, "../sound/PicoHammerHit.wav", false);

			// 初期化
			init();
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imageBackground, 0, 0, 800, 600, this);
		g.drawImage(imgMogus[idxMogu], moguX, moguY, 100, 100, this);

		g.drawImage(imgMogus[idxMogu2], moguX2, moguY2, 100, 100, this);  /*Question5*/

		g.drawImage(imgHammers[idxHummer], hummerX, hummerY, 100, 100, this);

		g.setColor(Color.YELLOW);
		g.setFont(fontBase);
		g.drawString("得点：" + score, 0, 24);
		if (phase == 0) {
			// ゲーム中
			g.setColor(Color.RED);
			g.setFont(fontBase);
			g.drawString("残り時間：" + (gameTime / 60) , 300, 24);
		} else if (phase == 1) {
			// ゲームオーバー
			g.setColor(Color.ORANGE);
			g.setFont(fontGameOver);

			if (score >= 30) {
				g.drawString("ゲームオーバー：Excellent！", 50, 300);
			} else if (score >= 20) {
				g.drawString("ゲームオーバー：Great！", 100, 300);
			} else if (score >= 10) {
				g.drawString("ゲームオーバー：Good！", 100, 300);
			} else {
				g.drawString("ゲームオーバー：Bad！", 100, 300);
			}
		}
	}

	/** 初期化処理(しょきかしょり) */
	public void init() {
		phase = 0; //ゲーム中にする
		idxMogu = 0; //もぐらの画像を指定
		score = 0; //得点を0点にする

		gameTime = 1800; //ゲームの時間
		//BGMを再生(さいせい)する
		midiMoguraDance.init();
		midiMoguraDance.start();
	}

	class MoguThread extends Thread implements Runnable {
		public MoguThread() {
			super();
		}

		public void run() {
			while (true) {
				try {
					Thread.sleep(16);
				} catch (InterruptedException e) {

				}
			/**　Question3,4　*/
				if(respawnMogu == 0) {
					if (gameTime > 600) {
						respawnMogu = 60;
					} else {
						respawnMogu = 30;
					}
				}
			/**　Question3,4　*/
				gameTime--; //残り時間のカウントダウン
				if (phase == 0) {
					if (gameTime == 0) {
						gameTime = 300; //再ゲームまでの時間
						phase = 1; //状態をゲームオーバーにする
					} else {
						//もぐらを出現させる処理 (出現時間の調整）
						if (respawnMogu != 0) {

							respawnMogu--;
							if (respawnMogu == 0) {
								idxMogu = 0;
								//もぐらの出現位置(しゅつげんいち)をランダムに設定
								moguX = (int) (Math.random() * 550);
								moguY = (int) (Math.random() * 450);

								//効果音(こうかおん)を再生する
//								waveMoguraDeru.start();
							}
						}
					}
				} else if (phase == 1) {
					if (gameTime == 0) {
						init(); //初期化
					}
				}
				repaint();
			}
		}
	}
	
	/*Question5*/
	class MoguThread1 extends Thread implements Runnable {
		public MoguThread1() {
			super();
		}

		public void run() {
			while (true) {
				try {
					Thread.sleep(16);
				} catch (InterruptedException e) {

				}
			/**　Question3,4　*/
				if(respawnMogu2 == 0) {
					if (gameTime > 600) {
						respawnMogu2 = 60;
					} else {
						respawnMogu2 = 30;
					}
				}
			/**　Question3,4　*/

//				gameTime--; //残り時間のカウントダウン  /*Question5*/
				if (phase == 0) {
					if (gameTime == 0) {
						gameTime = 300; //再ゲームまでの時間
						phase = 1; //状態をゲームオーバーにする
					} else {
						//もぐらを出現させる処理 (出現時間の調整）
						if (respawnMogu2 != 0) {

							respawnMogu2--;
							if (respawnMogu2 == 0) {
								idxMogu2 = 0;
								//もぐらの出現位置(しゅつげんいち)をランダムに設定
								moguX2 = (int) (Math.random() * 550);
								moguY2 = (int) (Math.random() * 450);

								//効果音(こうかおん)を再生する
//								waveMoguraDeru.start();
							}
						}
					}
				} else if (phase == 1) {
					if (gameTime == 0) {
						init(); //初期化
					}
				}
				repaint();
			}
		}
	}

	/** マウスイベントを管理するクラス */
	class GameMouseAdapter extends MouseAdapter {
		/** マウスがおされた */
		public void mousePressed(MouseEvent me) {
			idxHummer = 1; //ハンマー画像の指定(してい)
			//ハンマーの位置(いち)を取得(しゅとく)
			hummerX = me.getX() - x;
			hummerY = me.getY() - y;

			if (idxMogu == 0) {
				//当たり判定
				if (hummerX > moguX - 50 && hummerX < moguX + 90
						&& hummerY > moguY - 70 && hummerY < moguY + 60) {
					idxMogu = 1;
					respawnMogu = 30; //次回もぐら表示までの時間

					/**　Question1　*/
					System.out.println("☆");
					if (gameTime > 600) {
						//10秒以上
						score++; //得点を追加する
					} else {
						//10秒以下
						score = score + 2; //得点を追加する
					}

					//効果音(こうかおん)を再生する
					wavePikoHammerHit.start();
				} else {
					//効果音(こうかおん)を再生する
					wavePikoHammerMiss.start();
				}
			}
			
			/*Question5*/
			if (idxMogu2 == 0) {
				//当たり判定
				if (hummerX > moguX2 - 50 && hummerX < moguX2 + 90
						&& hummerY > moguY2 - 70 && hummerY < moguY2 + 60) {
					idxMogu2 = 1;
					respawnMogu2 = 30; //次回もぐら表示までの時間

					System.out.println("★");
					/**　Question1　*/
					if (gameTime > 600) {
						//10秒以上
						score++; //得点を追加する
					} else {
						//10秒以下
						score = score + 2; //得点を追加する
					}

					//効果音(こうかおん)を再生する
					wavePikoHammerHit.start();
				} else {
					//効果音(こうかおん)を再生する
					wavePikoHammerMiss.start();
				}
			}

		}

		/** マウスがはなされた */
		public void mouseReleased(MouseEvent me) {
			idxHummer = 0; //ハンマー画像の指定(してい)
			//ハンマーの位置(いち)を取得(しゅとく)
			hummerX = me.getX() - x;
			hummerY = me.getY() - y;
		}
		/** マウスを動かした */
		public void mouseMoved(MouseEvent me) {
			//ハンマーの位置(いち)を取得(しゅとく)
			hummerX = me.getX() - x;
			hummerY = me.getY() - y;
		}

		/** マウスをドラッグした */
		public void mouseDragged(MouseEvent me) {
			//ハンマーの位置(いち)を取得(しゅとく)
			hummerX = me.getX() - x;
			hummerY = me.getY() - y;
		}
	}
}
