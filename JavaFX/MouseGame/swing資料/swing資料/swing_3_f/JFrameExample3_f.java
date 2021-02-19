package swing_3_f;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExample3_f extends JFrame {
	public JFrameExample3_f() {
		// Frameのサイズをきめます
		setSize(400,400);
		// タイトルを追加（ついか）します
		setTitle("パネルに画像を表示する");
		// Close ボタンを押（お）したときの動作（どうさ）をきめます
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//コンテナを作成（さくせい）して、パネルを貼（は）りつけます。
		Container cont = getContentPane();
		PicturePanel panel1 = new PicturePanel();
		cont.add(panel1)	;		//コンテナにパネルをはる
		PicturePanel2 panel2 = new PicturePanel2();
		cont.add(panel2)	;		//コンテナにパネルをはる
		PicturePanel3 panel3 = new PicturePanel3();
		cont.add(panel3)	;		//コンテナにパネルをはる
	}

	public static void main(String[] args) {
		// コンストラクタをよびだす
		JFrame frame = new JFrameExample3_f();
		// GUIに表示（ひょうじ）します
		frame.setVisible(true);
	}
}
class PicturePanel extends JPanel {
	// コンストラクタ
	public PicturePanel() {
		// パネルの背景色（はいけいしょく）をつけます。
		setBackground(Color.PINK);
	}
	// パネルに画像（がそう）を描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 飛行機（ひこうき）の画像（がぞう）を読み込（よみこみ）みます。
		ImageIcon icon1 = new ImageIcon("src/img/airplane.gif");
		Image image1 = icon1.getImage();

		// 画像（がぞう）を描画（びょうが）します。
		g.drawImage(image1,10, 50, this);
		g.drawImage(image1,60,  100, 150, 100, this);

	// 勇者（ゆうしゃ）の画像（がぞう）を読み込（よみこみ）みます。
		ImageIcon icon2= new ImageIcon("src/img/yuusha.gif");
		Image image2 = icon2.getImage();

	// 画像（がぞう）を描画（びょうが）します。
		g.drawImage(image2, 270, 30, 160, 200, this);
	}
}
class PicturePanel2 extends JPanel {
	// コンストラクタ
	public PicturePanel2() {
		// パネルの背景色（はいけいしょく）をつけます。
		setBackground(Color.ORANGE);
	}
	// パネルに画像（がそう）を描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 飛行機（ひこうき）の画像（がぞう）を読み込（よみこみ）みます。
		ImageIcon icon1 = new ImageIcon("src/img/totoro.png");
		Image image1 = icon1.getImage();
		// 画面の大きさを得る（がめんのおおきさをえる）
		Dimension d = getSize();
		int screenWidth = d.width;
		int screenHeight = d.height;

		// 画像の大きさを得る（がぞうのおおきさをえる）
	    int imgWidth = image1.getWidth(this);
	    int imgHeight = image1.getHeight(this);
	   // 画像を中心（ちゅうしん）に置（お）くための座標（ざひょう）をもとめる
		int  pointX = (screenWidth - imgWidth ) /2 ;
		int  pointY = (screenHeight - imgHeight ) /2;
		g.drawImage(image1,pointX, pointY, this);

	}
}
class PicturePanel3 extends JPanel {
	// コンストラクタ
	public PicturePanel3() {
		// パネルの背景色（はいけいしょく）をつけます。
		setBackground(Color.BLUE);
	}
	// パネルに画像（がそう）を描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// オリンピックの画像（がぞう）を読み込（よみこみ）みます。
		ImageIcon icon1 = new ImageIcon("src/img/Olympic.png");
		Image image1 = icon1.getImage();
		g.drawImage(image1,0, 0, this);

		ImageIcon icon2 = new ImageIcon("src/img/totoro.gif");
		Image image2 = icon2.getImage();
		g.drawImage(image2, 200, 0,150, 150, this);

		ImageIcon icon3 = new ImageIcon("src/img/rat.png");
		Image image3 = icon3.getImage();
		g.drawImage(image3, 0, 200, 150, 150, this);

		ImageIcon icon4 = new ImageIcon("src/img/Xmas.png");
		Image image4 = icon4.getImage();
		g.drawImage(image4, 200, 200, this);

	}
}
