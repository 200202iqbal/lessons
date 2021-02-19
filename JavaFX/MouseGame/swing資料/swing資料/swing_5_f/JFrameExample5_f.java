package swing_5_f;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JFrameExample5_f extends JFrame {
	public JFrameExample5_f() {
		setSize(400, 300);
		setTitle("イベントに対応する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();
		ActionPanel1 panel1 = new ActionPanel1();
		cont.add(panel1);
		ActionPanel2 panel2 = new ActionPanel2();
		cont.add(panel2);
		ActionPanel3 panel3 = new ActionPanel3(); // うまく動きません！！
		cont.add(panel3); // うまく動きません！！
		ActionPanel4 panel4 = new ActionPanel4();
		cont.add(panel4);

		ActionPanel5 panel5 = new ActionPanel5();
		cont.add(panel5);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample5_f();
		frame.setVisible(true);
	}
}

class ActionPanel1 extends JPanel {
	int clickX, clickY; // クリック位置（いち）座標（ざひょう）
	int dragX, dragY; //ドラッグ位置（いち）座標（ざひょう）
	boolean flag = true;

	public ActionPanel1() {
		setBackground(Color.PINK);
		// イベントを有効にする
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);

		MyMouseMotionAdapter motionAdapter = new MyMouseMotionAdapter();
		addMouseMotionListener(motionAdapter);

		// クリック座標（ざひょう）
		clickX = 0;
		clickY = 0;
		//ドラッグ座標（ざひょう）
		dragX = 0;
		dragY = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int startX = clickX; // 始点（してん）のｘ座標（ざひょう）
		int startY = clickY; // 始点（してん）のｙ座標（ざひょう）

		int width = dragX - clickX; //図形（ずけい）の幅（はば）
		int height = dragY - clickY; //図形（ずけい）の高さ（たかさ）

		//始点（してん）のｘ軸（じく）と幅（はば）を決める（きめる）
		if (startX > dragX) {
			startX = dragX;
			width = clickX - dragX;
		}
		//始点（してん）のy軸（じく）と高さ（はば）を決める（きめる）
		if (startY > dragY) {
			startY = dragY;
			height = clickX - dragY;
		}
		// Shiftキーが押（お）された場合（ばあい）
		String str = "false";
		if (flag == true) {
			height = width; // 幅（はば）と高さ（たかさ）を同（おな）じにする
			str = "true";
		}

		g.drawString(str, startX - 20, startY - 20);
		g.drawOval(startX, startY, width, height); // 図形（ずけい）の描画（びょうが）
	}

	class MyMouseAdapter extends MouseAdapter {
		/** マウスが押されたら */
		@Override
		public void mousePressed(MouseEvent e) {
			// クリックした位置（いち）の座標（ざひょう）を取得（しゅとく）する
			clickX = e.getX();
			clickY = e.getY();
			dragX = clickX;
			dragY = clickY;
			repaint(); //再描画指示（さいびょうがしじ）
		}
	}

	class MyMouseMotionAdapter extends MouseMotionAdapter {
		/** マウスがドラッグされたら　*/
		@Override
		public void mouseDragged(MouseEvent e) {
			//ドラッグされた位置座標（いちざひょう）を取得（しゅとく）する
			dragX = e.getX();
			dragY = e.getY();

			if ((e.getModifiers() & InputEvent.SHIFT_MASK) == 0) {
				// シフトキーがおされていない
				flag = false;
			} else {
				// シフトキーが押された
				flag = true;
			}
			repaint();
		}
	}
}

class ActionPanel2 extends JPanel {
	// おされたキーを判断（はんだん）するための変数（へんすう）
	int flag = 0;

	public ActionPanel2() {
		setBackground(Color.CYAN);
		// イベントを有効にする
		MyKeyAdapter keyAdapter = new MyKeyAdapter();
		addKeyListener(keyAdapter);
	}

	// キーイベントを受け取る（うけとる）
	@Override
	public boolean isFocusable() {
		return true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// フォントを設定（せってい９する
		Font normalFont = new Font("ＭＳ ゴシック ", Font.BOLD, 30);
		Font largeFont = new Font("ＭＳ ゴシック ", Font.BOLD, 40);

		if (flag == 1) {
			// 	// 『↑』キーが押されたキーが押された
			g.setFont(largeFont);
		} else {
			// 『↓』キーが押された
			g.setFont(normalFont);
		}
		g.drawString("うえ", 100, 100);
		if (flag == 2) {
			// 『↓』キーが押された
			g.setFont(largeFont);
		} else { // 『↑』キーが押された
			g.setFont(normalFont);
		}
		g.drawString("した", 100, 200);

	}

	class MyKeyAdapter extends KeyAdapter {
		/** キーが押されたら */
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				flag = 1;
				break; // 『↑』
			case KeyEvent.VK_DOWN:
				flag = 2;
				break; // 『↓』
			default:
				flag = 0;
				break; // その他（た）のキー
			}
			repaint();
		}
	}
}

class ActionPanel3 extends JPanel {
	// おされたキーを判断（はんだん）するための変数（へんすう）
	boolean flag = true;

	public ActionPanel3() {
		setBackground(Color.YELLOW);
		// イベントを有効にする
		MyFocusAdapter focusAdapter = new MyFocusAdapter();
		addFocusListener(focusAdapter);
	}

	// キーイベントを受け取る（うけとる）
	@Override
	public boolean isFocusable() {
		return true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// フォントを設定（せってい)する
		Font font = new Font("ＭＳ ゴシック ", Font.BOLD, 30);
		g.setFont(font);

		if (flag == true) {
			//フォーカスイン
			//			JTextField jtext = new JTextField("FOCUS IN", 20);
			g.drawString("FOCUS IN", 10, 100);
			//			add(jtext);
		} else {
			// フォーカスアウト
			//			JTextField jtext = new JTextField("FOCUS OUT", 20);
			g.drawString("FOCUS OUT", 10, 100);
			//			add(jtext);
		}
	}

	class MyFocusAdapter extends FocusAdapter {
		/** フォーカスイン */

		@Override
		public void focusGained(FocusEvent e) {
			flag = true;
			System.out.println("In");
			repaint(); // 再描画（さいびょうが）
		}

		/** フォーカスアウト */

		@Override
		public void focusLost(FocusEvent e) {
			flag = false;
			System.out.println(("out"));
			repaint(); // 再描画（さいびょうが）
		}
	}

}

class ActionPanel4 extends JPanel implements ActionListener {
	Image image; // 画像（がぞう）イメージ
	int x, y; //座標（ざひょう）
	Timer timer; // タイマー
	int counter = 0; // カウンタ

	public ActionPanel4() {
		setBackground(Color.PINK);
		// 画像の読み込み
		ImageIcon icon = new ImageIcon("src/img/airPlane.gif");
		image = icon.getImage();

		// 始点（してん）の座標（ざひょう）
		x = 0;
		y = 50;

		// タイマーの起動（きどう）
		timer = new Timer(100, this); // 100 msごとにイベントを発生（はっせい）させる
		timer.start();
	}

	// キーイベントを受け取る（うけとる）
	@Override
	public boolean isFocusable() {
		return true;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}

	// イベントの処理を決める（しょりをきめる）
	@Override
	public void actionPerformed(ActionEvent e) {
		x += 5;
		repaint();

		counter++;
		if (counter == 100) {//100回繰り返したら終了
			timer.stop();// イベントをストップする
		}
	}

}

class ActionPanel5 extends JPanel {
	int x, y; // 座標（ざひょう）

	public ActionPanel5() {
		setBackground(Color.PINK);
		// イベントを有効にする
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);

		MyMouseMotionAdapter motionAdapter = new MyMouseMotionAdapter();
		addMouseMotionListener(motionAdapter);
	}

	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			// 始点（してん）の座標（ざひょう）をきめる
			x = e.getX();
			y = e.getY();
		}
	}

	class MyMouseMotionAdapter extends MouseMotionAdapter {
		/** マウスがドラッグされたら　*/
		@Override
		public void mouseDragged(MouseEvent e) {
			//ドラッグした座標（ざひょう）に線（せん）をひく
			Graphics g = getGraphics();
			g.drawLine(x, y, e.getX(), e.getY());

			// 次の線（つぎのせん）をひくために、始点（してん）を更新（こうしん）する
			x = e.getX();
			y = e.getY();
		}
	}
}
