package fr.heighties.testdeplacementschrichri;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = -7768607522576631470L;
	MyPanel panel;

	MyFrame() {

		panel = new MyPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}