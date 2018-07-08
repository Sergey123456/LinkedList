package telran.util;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewTestGUI extends JFrame {
	public NewTestGUI() {
		setTitle("Hello world!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 100, 400, 900);
		
		
		JButton[] jButtons = new JButton[5];
		JButton jbs = new JButton("Shmi Daniel");
		for (int i = 0; i < jButtons.length; i++) {
			jButtons[i] = new JButton("" + i);
		}
		setLayout(new BorderLayout());
		add(jButtons[0], BorderLayout.EAST);
		add(jButtons[1], BorderLayout.WEST);
		add(jButtons[2], BorderLayout.SOUTH);
		add(jButtons[3], BorderLayout.NORTH);
		add(jButtons[4], BorderLayout.CENTER);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		NewTestGUI window = new NewTestGUI();
	}
}

