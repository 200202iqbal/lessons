package swing_10;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaGameEx3 extends JFrame {
	public JavaGameEx3() {
		setSize(600, 450);
		setTitle("くろひげ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		KHPanel panel = new KHPanel();
		setContentPane(panel);
	}

	public static void main(String[] args) {
		JavaGameEx3 frame = new JavaGameEx3();
		frame.setVisible(true);
	}
}

class KHPanel extends JPanel {
	/** カーソル位置 */
	private int x = 20; // ｘ座標
	private int y = 25; // ｙ座標
	/**　剣の位置　*/
	private int swordX =0; // ｘ座標
	private int swordY = 0; // ｙ座標
	/**　樽（たる）の位置　*/
	private int taruX = 150; // ｘ座標
	private int taruY = 125; // ｙ座標
	/**　画像　*/
	private Image imgBackground = null; //背景
	private Image[] imgSwords = new Image[3]; // 剣
	private Image[] imgChara = new Image[3]; // キャラクター
	private Image imgTaru = null; // 樽（たる）

	private int idxSword = 0; // 剣画像のindex
	private int idxChara = 0; // キャラクター画像のindex

	/**　フェーズ　*/
	private int phase = 0;
	private final int PHASE_GAME = 0;
	private final int PHASE_GAMEOVER = 1;

	/**  ゲーム管理  */
	private Font fontBase = new Font("MS ゴシック", Font.BOLD | Font.ITALIC, 24);
	private Font fontGameOver = new Font("MS ゴシック", Font.BOLD | Font.ITALIC, 48);
	private int time = 0; // 時間
	private boolean isClick = false; // true = クリックした　false = クリックしない

	/** 四角形を生成　　*/
	private Rectangle[] rects = new Rectangle[5];
	/** 四角形に剣が当たったかどうかの判定(はんてい）　 */
	private boolean[] isRects = new boolean[5];

	private int atariNo = 99; //当たりNo
	private int hitNo = 99; // 決定No
	private int touchNo = 99; // タッチNo

	public KHPanel() {
		//マウスイベントを有効化する
		KHMouseAdapter adapter = new KHMouseAdapter();
		addMouseListener(adapter);
		addMouseMotionListener(adapter);

		// 背景画像（はいけいがぞう）の読み込み
		ImageIcon icon = new ImageIcon("src/KHGame/img/BackgroundSea.png");
		imgBackground = icon.getImage();

		// 剣（けん）の画像を読み込む
		icon = new ImageIcon("src/KHGame/img/Sword1.gif");
		imgSwords[0] = icon.getImage();
		icon = new ImageIcon("src/KHGame/img/Sword2.gif");
		imgSwords[1] = icon.getImage();
		icon = new ImageIcon("src/KHGame/img/Sword3.gif");
		imgSwords[2] = icon.getImage();

		// キャラクターの画像を読み込む
		icon = new ImageIcon("src/KHGame/img/Chara1.gif");
		imgChara[0] = icon.getImage();
		icon = new ImageIcon("src/KHGame/img/Chara2.gif");
		imgChara[1] = icon.getImage();
		icon = new ImageIcon("src/KHGame/img/Chara3.gif");
		imgChara[2] = icon.getImage();

		// 樽（たる）の画像の読み込み
		icon = new ImageIcon("src/KHGame/img/taru.png");
		imgTaru = icon.getImage();

		KHThread thread = new KHThread();
		thread.start();

		// 四角形の情報セット
		for (int i = 0; i < rects.length; i++) {
			int position = 16;
			if (i == 0 || i == 4) {
				position = 0;
			} else if (i == 1 || i == 3) {
				position /= 2;
			}
			rects[i] = new Rectangle(190 + i * 35, 270 + position, 20, 50);
		}
		init();
	}

	public void init() {
		phase = PHASE_GAME; //フェーズをゲーム中にする
		time = 1859;

		idxChara = 0;

		atariNo = (int) (Math.random() * rects.length);
		touchNo = 99;
		hitNo = 99;

		// 剣の状態（刺されていない＝false）
		for (int i = 0; i < isRects.length; i++) {
			isRects[i] = false;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		// 背景（はいけい）を描画（びょうが）する
		g.drawImage(imgBackground, 0, 0, 600, 450, this);
		// 樽（たる）を描画する。
		g.drawImage(imgTaru, taruX, taruY, 250, 300, this);
		// 画面に四角形を描画する
		for (int i = 0; i < rects.length; i++) {
			if (i == hitNo) {
				g.setColor(Color.RED);
				isRects[i] = true;
			} else if (i == touchNo) {
				g.setColor(Color.PINK);
			} else {
				g.setColor(Color.ORANGE);
			}
			g.fillRect(rects[i].x, rects[i].y, rects[i].width, rects[i].height);
		}
		//キャラクターを描画する
		if (idxChara != 2) { // 0：ノーマル顔　//１：あせり顔
			g.drawImage(imgChara[idxChara], taruX + 70, taruY - 50, 100, 100, this);
		} else {
			g.drawImage(imgChara[idxChara], taruX + 30, taruY - 100, 100, 100, this);
		}
		// 剣を描画する
		if (isClick == false) {
			g.drawImage(imgSwords[idxSword], swordX, swordY, 60, 60, this);
		}
		// 刺した剣を描画する
		for (int i = 0; i < isRects.length; i++) {
			if (isRects[i] == true) {
				if (i < rects.length / 2) {
					g.drawImage(imgSwords[1], rects[i].x - 20, rects[i].y, 40, 40, this);
				} else {
					g.drawImage(imgSwords[2], rects[i].x + 5, rects[i].y, 40, 40, this);
				}
			}
		}
		if (phase == PHASE_GAME) {
			g.setColor(Color.RED);
			g.setFont(fontBase);
			g.drawString("残り時間:" + time / 60, 200, 24);
			if (isClick == true) {
				g.setColor(Color.YELLOW);
				g.setFont(fontBase);
				g.drawString("セーフ", 0, 24);
			}

		} else if (phase == PHASE_GAMEOVER) {
			g.setColor(Color.RED);
			g.setFont(fontGameOver);
			g.drawString("ゲームオーバー", 100, 225);

			g.setFont(fontBase);
			g.drawString("アウト！", 0, 24);
		}
	}

	class KHThread extends Thread implements Runnable {
		public KHThread() {
			super();
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(16);
				} catch (InterruptedException e) {

				}
				time--; //制限時間を減らす
				//制限（せいげん）時間がきたら
				if (time == 0) {
					if (phase == PHASE_GAME) {
						phase = PHASE_GAMEOVER; // ゲームオーバーにする
						time = 300; //ゲームオーバーまでの時間を設定（せってい）
					} else if (phase == PHASE_GAMEOVER) {
						init();
					}
				}
				repaint();
			}
		}
	}

	/** マウスイベントを管理するクラス　*/
	class KHMouseAdapter extends MouseAdapter {
		/** マウスが押された */
		@Override
		public void mousePressed(MouseEvent me) {
			swordX = me.getX() - x;
			swordY = me.getY() - y;

			isClick = true;

			for (int i = 0; i < rects.length; i++) {
				// 剣（けん）のあたりの判定（はんてい）
				if (me.getX() >= rects[i].x && me.getX() < rects[i].x + rects[i].width
						&& me.getY() > rects[i].y && me.getY() < rects[i].y + rects[i].height) {
					hitNo = i;
					if (hitNo == atariNo) {
						phase = PHASE_GAMEOVER; // ゲームオーバーモード
						time = 100;
						idxChara = 2; // キャラクターの画像設定（がぞうせってい）
					}
					break;
				}
			}
		}

		/**  マウスが離された　*/
		@Override
		public void mouseReleased(MouseEvent me) {
			// 剣の位置を記憶する
			swordX = me.getX() - x;
			swordY = me.getY() - y;

			isClick = false;
		}

		/** マウスを動かした  */
		@Override
		public void mouseMoved(MouseEvent me) {
			if (idxChara < 2) {
				//剣の位置を記憶する
				swordX = me.getX() - x;
				swordY = me.getY() - y;

				idxChara = 0;

				for (int i = 0; i < rects.length; i++) {
					// 剣のあたり判定（はんてい）
					if (me.getX() >= rects[i].x && me.getX() < rects[i].x + rects[i].width
							&& me.getY() > rects[i].y && me.getY() < rects[i].y + rects[i].height) {
						if (isRects[i] == false) {
							touchNo = i;
							idxChara = 1; //キャラクターの画像設定
						}
						break;
					}
				}
			}
		}
	}
}