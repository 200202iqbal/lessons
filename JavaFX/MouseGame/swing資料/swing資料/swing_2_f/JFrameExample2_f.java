package swing_2_f;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExample2_f extends JFrame {
	// コンストラクタ
	public JFrameExample2_f() {
		//画面（がめん）のサイズ
		setSize(400, 300);
		// タイトルをついかします
		setTitle("パネルに図形を表示する");
		// 終了処理（しゅうりょうしょり）
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//コンテナを作成（さくせい）してパネルを貼る（はる）
		Container cont = getContentPane();
		FigureJPanel1 panel1 = new FigureJPanel1();  // パネルの生成（せいせい）
		cont.add(panel1); // コンテナにパネルを貼る（はる）

		FigureJPanel2 panel2= new FigureJPanel2();  // パネルの生成（せいせい）
		cont.add(panel2); // コンテナにパネルを貼る（はる）

		FigureJPanel3 panel3= new FigureJPanel3();  // パネルの生成（せいせい）
		cont.add(panel3); // コンテナにパネルを貼る（はる）

		FigureJPanel4 panel4= new FigureJPanel4();  // パネルの生成（せいせい）
		cont.add(panel4); // コンテナにパネルを貼る（はる）
	}
	public static void main(String[] args) {
		// コンストラクタの呼び出し
		JFrame frame = new JFrameExample2_f();
		//　GUIに表示（ひょうじ）します。
		frame.setVisible(true);
	}
}
class FigureJPanel1 extends JPanel {
	//コンストラクタ
	FigureJPanel1(){
		// パネルに背景色（はいけいしょく）を付ける
		setBackground(Color.WHITE);
	}
	// Paneに描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 文字（もじ）を描画（びょうが）する
		g.drawString("矢印（やじるし）", 40, 40);

		// 図形（ずけい）の描画（びょうが）をする　その１
		g.drawLine(20, 100, 120, 100);
		g.drawLine(90, 70, 120, 100);
		g.drawLine(90, 130, 120, 100);
		// 図形（ずけい）の描画（びょうが）をする　その2
		g.setColor(Color.RED);
		g.drawLine(200, 100, 200, 200);
		g.drawLine(200, 100, 170, 130);
		g.drawLine(200, 100, 230, 130);
		// 図形（ずけい）の描画（びょうが）をする　その3
		g.setColor(Color.BLUE);
		g.drawLine(250, 100, 250, 200);
		g.drawLine(220, 170, 250, 200);
		g.drawLine(280, 170, 250, 200);

	}
}
class FigureJPanel2 extends JPanel {
	//コンストラクタ
	FigureJPanel2(){
		// パネルに背景色（はいけいしょく）を付ける
		setBackground(Color.PINK);
	}
	// Paneに描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 四角形（しかくけい）を描画（びょうが）する
		g.drawRect(20, 20, 120, 60);

		// 塗（ぬ）りつぶした四角形を描画（びょうが）する
		g.setColor(Color.BLUE);
		g.fillRect(180, 20, 120, 60);

		// 角（かど）を丸（まる）めた四角形（しかくけい）
		g.setColor(Color.RED);
		g.drawRoundRect(20, 100, 120, 60, 20, 20);

		// 角（かど）を丸（まる）めた塗（ぬ）りつぶした四角形（しかくけい）
		g.setColor(Color.WHITE);
		g.fillRoundRect(180, 100, 120, 60, 30, 30);

	}
}
class FigureJPanel3 extends JPanel {
	//コンストラクタ
	FigureJPanel3(){
		// パネルに背景色（はいけいしょく）を付ける
		setBackground(Color.PINK);
	}
	// Paneに描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 円（えん）を描画（びょうが）する
		g.drawOval(20, 20, 80, 80);

		// 塗（ぬ）りつぶした円（えん）を描画（びょうが）する
		g.setColor(Color.BLUE);
		g.fillOval(160, 20, 100, 100);

		// 角（かど）を丸（まる）めた四角形（しかくけい）
		g.setColor(Color.RED);
		g.drawOval(30, 120, 60, 120);

		// 角（かど）を丸（まる）めた塗（ぬ）りつぶした四角形（しかくけい）
		g.setColor(Color.WHITE);
		g.fillOval(180, 140, 120, 60);

	}
}
class FigureJPanel4 extends JPanel {
	//コンストラクタ
	FigureJPanel4(){
		// パネルに背景色（はいけいしょく）を付ける
		setBackground(Color.PINK);
	}
	// Paneに描画（びょうが）するメソッドです。
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 円（えん）を描画（びょうが）する
		g.drawArc(20, 20, 80, 80, 0, 90);

		// 塗（ぬ）りつぶした円（えん）を描画（びょうが）する
		g.setColor(Color.BLUE);
		g.fillArc(160, 20, 100, 100, 0, -120);

		// 角（かど）を丸（まる）めた四角形（しかくけい）
		g.setColor(Color.RED);
		g.drawArc(30, 120, 60, 120, 90, 150);

		// 角（かど）を丸（まる）めた塗（ぬ）りつぶした四角形（しかくけい）
		g.setColor(Color.WHITE);
		g.fillArc(180, 140, 120, 60, 90, 150);

	}
}