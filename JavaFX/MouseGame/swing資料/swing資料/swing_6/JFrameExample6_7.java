package swing_6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameExample6_7 extends JFrame {
	JButton button;	//コンソール転送ボタン
	JTextArea textArea; // テキストエリア

	public JFrameExample6_7() {
		setSize(600, 300);
		setTitle("GUI部品を配置する");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container cont = getContentPane();

		textArea = new JTextArea(10, 35); // テキストエリアの作成
		textArea.setLineWrap(true);
		button = new JButton("コンソールへ転送");

		JScrollPane pane = new JScrollPane(textArea); // テキストエリアにスクロールを付ける
		PartsButtonPanel panelButton = new PartsButtonPanel();

		panelButton.add(button);
		button.addActionListener(panelButton);

		cont.setLayout(new BorderLayout());
		cont.add(pane, BorderLayout.CENTER);
		cont.add(panelButton, BorderLayout.NORTH);

	}
	public static void main(String[] args) {
		JFrame frame = new JFrameExample6_7();
		frame.setVisible(true);
	}
	class PartsButtonPanel extends JPanel implements ActionListener {
		//ボタンが押されたら
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = textArea.getText(); //テキストエリアの値を取得
			System.out.println(s);
		}
	}
}
