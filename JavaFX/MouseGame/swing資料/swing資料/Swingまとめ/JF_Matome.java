package SwingMatome;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class JF_Matome extends JFrame{

		public JF_Matome() {	//コンストラクタ
			setSize(400, 300);	//Window サイズ設定（せってい）
			setTitle("マイプログラム");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
						//パネルを用意(ようい)
			Container cont = getContentPane();
			ActionPanel1 panel1 = new ActionPanel1();
			cont.add(panel1);
		}

		public static void main(String[] args) {
			JFrame frame = new JF_Matome();//フレーム生成
			frame.setVisible(true); //見えるようにする
		}
		/** 以下に、JPanelのクラスを記述します（内部クラスで書く場合）*/
		/**         JPanelは別クラスで記述してもOKです */
		/** ３．項のJPanelを張り付け、挿入してください。  */
		class ActionPanel1 extends JPanel {
			int clickX, clickY; // クリック位置（いち）座標（ざひょう）

			public ActionPanel1() {
				setBackground(Color.PINK);
				// イベントを有効にするActionListnerをこの後に追記します
				/**  Listenerの記述　６項のイベントを挿入してください*/
				MyMouseAdapter adapter = new MyMouseAdapter();
				addMouseListener(adapter);


			}
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);	// 必ず記述、描画の前準備に相当
				//描画する本体を記述する　以下は例

				g.drawString("マイゲーム", 20, 20);
				g.drawOval(clickX, clickY, 80,80); // 図形（ずけい）の描画（びょうが）
			}
			class MyMouseAdapter extends MouseAdapter {
				/** マウスが押（お）されたら　*/
				@Override
				public void mousePressed(MouseEvent e) {
					clickX = e.getX();// クリック位置（いち）の取得
					clickY = e.getY();
					repaint(); // 再描画要求（さいびょうがようきゅう）
				}
		}
	}
}
