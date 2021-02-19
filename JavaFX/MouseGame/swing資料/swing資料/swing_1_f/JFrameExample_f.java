package swing_1_f;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import swing_1.JFrameExample;

public class JFrameExample_f extends JFrame {
	public JFrameExample_f() { //コンストラクタ
		setSize(500, 300); // フレームのサイズの指定（してい）
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 終了の条件（しゅうりょうのじょうけん）クローズボタンがおされたら
		//Windwowのタイトルをつける
		setTitle("JFarmeのテスト");
		// コンテナを作成（さくせい）してパネルを貼る（はる）
		Container cont = getContentPane(); // コンテナを取得（しゅとく）
		MyJPanel panel = new MyJPanel(); // パネルを作成（さくせい）
		cont.add(panel); // コンテナにパネルを貼る（はる)
		// 2枚目のパネルを作成する
		MyJPanel2 panel2 = new MyJPanel2(); // パネルを作成（さくせい）
		cont.add(panel2); // コンテナにパネルを貼る（はる)
		// ３枚目のパネルを作成する
		MyJPanel3 panel3 = new MyJPanel3(); // パネルを作成（さくせい）
		cont.add(panel3); // コンテナにパネルを貼る（はる)
	}

	//フレームの中に文字を表示する
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("JFrame", 10, 50);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrameExample(); //　インスタンス（ふれーむ）を生成（せいせい）
		frame.setVisible(true); // フレームを見えるようにする
	}
}

class MyJPanel extends JPanel {
	// コンストラクタ
	public MyJPanel() {
		setBackground(Color.PINK);
	}

	// パネルの描画（びょうが）するメソッド
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("JPanel", 20, 60);

		//文字（もじ）のフォントサイズを決める
		Font font= new Font("MS Pゴシック", Font.ITALIC, 14);
		g.setFont(font);
		g.drawString("あいうえお", 40, 100);

		//文字（もじ）のフォントサイズを決める
		font= new Font("MS 明朝", Font.BOLD, 20);
		g.setFont(font);
		g.drawString("かきくけこ", 60, 150);
	}
}
// 2枚目のパネル
class MyJPanel2 extends JPanel{
	// コンストラクタ
	public MyJPanel2() {
		setBackground(Color.CYAN);
	}
	// パネルの描画（びょうが）するメソッド
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//文字列を設定する
		String str = "JPanel2";

		// 描画（びょうが）サイズを取得（しゅとく）
		Dimension d = getSize();

	   //文字（もじ）のサイズを取得（しゅとく）
		FontMetrics fm = g.getFontMetrics(); // 文字列情報（もじれつじょうほう）の取得（しゅとく）
		int strWidth = fm.stringWidth(str);//　文字列（もじれつ）の幅（はば）を求（もと）める
		int strHeight = fm.getHeight();  // 文字列（もじれつ）の高（たか）さを求（もと）める

		// 表示位置（ひょうじいち）を求める
		int x = (d.width - strWidth) / 2;
		int y = (d.height - strHeight)/ 2;

		// 文字列（もじれつ）を表示（ひょうじ）
		g.drawString(str, x, y);
	}
}
//３枚目のパネル
class MyJPanel3 extends JPanel{
	// コンストラクタ
	public MyJPanel3() {
		setBackground(Color.YELLOW);
	}
	// パネルの描画（びょうが）するメソッド
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//文字(もじ）に色（いろ）をつける①
		g.setColor(Color.BLUE);
		g.drawString("青色の文字です", 20, 60);

		//文字(もじ）に色（いろ）をつける②
		Color color = new Color(255, 0, 255);
		g.setColor(color);
		g.drawString("作成した色(255,0,255)の文字です", 40, 80);

	}
}
