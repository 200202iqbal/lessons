package swing_4_f;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameExample4_f extends JFrame {
	public JFrameExample4_f() {
		setSize(400, 300);
		setTitle("イベントに対応する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		EventPanel1 panel1 = new EventPanel1();
		cont.add(panel1);
		EventPanel2 panel2 = new EventPanel2();
		cont.add(panel2);

		EventPanel4 panel4 = new EventPanel4();
		cont.add(panel4);
		EventPanel5 panel5 = new EventPanel5();
		cont.add(panel5);
		EventPanel3 panel3 = new EventPanel3();
		cont.add(panel3);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample4_f();
		frame.setVisible(true);
	}
}

class EventPanel1 extends JPanel implements MouseListener {
	// クラス変数（へんすう）
	Image image;	// 画像（がぞう）
	int x,y; // 座標

	public EventPanel1() {	// コンストラクタ
		setBackground(Color.PINK);

		//画像（がぞう）のよみこみ
		ImageIcon icon = new ImageIcon("src/img/dog.gif");
		image = icon.getImage();

		//イベントを有効（ゆうこう）にする
		addMouseListener(this);
		// 始点（してん）の座標（ざひょう）
		x = 100;
		y = 100;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, x, y, this);
	}
	/** マウスが押（お）されたら　*/
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();// クリック位置（いち）の取得
		y = e.getY();

		repaint();  // 再描画要求（さいびょうがようきゅう）
	}
	/** マウスが離（はな）されたら　*/
	@Override
	public void mouseReleased(MouseEvent e) {
		// なにもかかないが、オーバーライドが必要(ひつよう）
	}
	/** マウスがクリックされたら　*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// なにもかかないが、オーバーライドが必要(ひつよう）
	}
	/** マウスが画面（がめん）にはいったら　*/
	@Override
	public void mouseEntered(MouseEvent e) {
		// なにもかかないが、オーバーライドが必要(ひつよう）
	}
	/** マウスが画面（がめん）から出（で）たら　*/
	@Override
	public void mouseExited(MouseEvent d) {
		// なにもかかないが、オーバーライドが必要(ひつよう）
	}

}
class EventPanel2 extends JPanel {
	// クラス変数（へんすう）
	Image image; // 画像（がぞう）
	int x, y; // 座標

	public EventPanel2() { // コンストラクタ
		setBackground(Color.CYAN);

		//画像（がぞう）のよみこみ
		ImageIcon icon = new ImageIcon("src/img/dog.gif");
		image = icon.getImage();

		//イベントを有効（ゆうこう）にする
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);
		// 始点（してん）の座標（ざひょう）
		x = 100;
		y = 100;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, x, y, this);
	}

	/**　マウスイベントを処理(しょり）するクラス　*/
	class MyMouseAdapter extends MouseAdapter {
		/** マウスが押（お）されたら　*/
		int dd;

		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();// クリック位置（いち）の取得
			y = e.getY();

			repaint(); // 再描画要求（さいびょうがようきゅう）
		}
	}

}
class EventPanel3 extends JPanel {
	// クラス変数（へんすう）
	Image image1; // 画像（がぞう）1
	Image image2; // 画像（がぞう）2
	int x, y; // 座標
	boolean flag = true; //　true：左（ひだり）クリック、false 右（みぎ）クリック

	public EventPanel3() { // コンストラクタ
		setBackground(Color.ORANGE);

		//画像（がぞう）のよみこみ
		ImageIcon icon1 = new ImageIcon("src/img/dog.gif");
		image1 = icon1.getImage();
		ImageIcon icon2= new ImageIcon("src/img/tree.gif");
		image2 = icon2.getImage();

		//イベントを有効（ゆうこう）にする
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);
		// 始点（してん）の座標（ざひょう）
		x = 100;
		y = 100;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(flag == true ) {	//　左（ひだり）クリックされた
			g.drawString("左クリック", x-20, y-20);
			g.drawImage(image1, x, y, this);
		} else {	// 　右（みぎ）クリックされた
			g.drawString("右クリック", x-20, y-20);
			g.drawImage(image2, x, y, this);
		}
	}

	/**　マウスイベントを処理(しょり）するクラス　*/
	class MyMouseAdapter extends MouseAdapter {
		/** マウスが押（お）されたら　*/
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();// クリック位置（いち）の取得
			y = e.getY();

			if(SwingUtilities.isRightMouseButton(e)) {
				flag = false;  // 右（みぎ）クリックされた
			}else {
				flag = true; // 左（ひだり）クリックされた
			}
			repaint(); // 再描画要求（さいびょうがようきゅう）
		}
	}

}
class EventPanel4 extends JPanel {
	// クラス変数（へんすう）
	Image image1; // 画像（がぞう）1
	Image image2; // 画像（がぞう）2
	int x, y; // 座標
	boolean flag = true; //　true：左（ひだり）クリック、false 右（みぎ）クリック

	public EventPanel4() { // コンストラクタ
		setBackground(Color.PINK);

		//画像（がぞう）のよみこみ
		ImageIcon icon1 = new ImageIcon("src/img/dog.gif");
		image1 = icon1.getImage();
		ImageIcon icon2= new ImageIcon("src/img/tree.gif");
		image2 = icon2.getImage();

		//イベントを有効（ゆうこう）にする
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);
		// 始点（してん）の座標（ざひょう）
		x = 100;
		y = 100;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(flag == true ) {	//　クリックされた
			g.drawImage(image1, x, y, this);
		} else {	// 　ダブルクリックされた
			g.drawImage(image2, x, y, this);
		}
	}

	/**　マウスイベントを処理(しょり）するクラス　*/
	class MyMouseAdapter extends MouseAdapter {
		/** マウスが押（お）されたら　*/
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();// クリック位置（いち）の取得
			y = e.getY();

			//ダプルクリックかどうか調（しら）べる
			if(e.getClickCount() == 2) {
				flag = false;  // ダプルクリックされた
			}else {
				flag = true; // シングルクリックされた
			}
			repaint(); // 再描画要求（さいびょうがようきゅう）
		}
	}

}class EventPanel5 extends JPanel {
	// クラス変数（へんすう）
	Image image; // 画像（がぞう）
	int x, y; // 座標
	boolean flag = true; //　true：左（ひだり）クリック、false 右（みぎ）クリック

	public EventPanel5() { // コンストラクタ
		setBackground(Color.GREEN);

		//画像（がぞう）のよみこみ
		ImageIcon icon = new ImageIcon("src/img/dog.gif");
		image = icon.getImage();

		//イベントを有効（ゆうこう）にする
		MyMouseMotionAdapter motionAdapter = new MyMouseMotionAdapter();
		addMouseMotionListener(motionAdapter);
		// 始点（してん）の座標（ざひょう）
		x = 100;
		y = 100;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, x, y, this);
	}
	/**　マウスイベントを処理(しょり）するクラス　*/
	class MyMouseMotionAdapter  extends MouseMotionAdapter {
		/** マウスがドラッグされたら*/
		@Override
		public void mouseDragged(MouseEvent e) {
			x = e.getX();// クリック位置（いち）の取得
			y = e.getY();
			repaint(); // 再描画要求（さいびょうがようきゅう）
		}
	}

}
