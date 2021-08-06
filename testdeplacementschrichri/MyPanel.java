package fr.heighties.testdeplacementschrichri;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 4288103529847771024L;

	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 600;
	Image chrichri;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 2;
	int yVelocity = 1;
	int x = 0;
	int y = 0;

	MyPanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		chrichri = new ImageIcon("chrichri.png").getImage();
		backgroundImage = new ImageIcon("space.png").getImage();
		timer = new Timer(5, this);
		timer.start();

	}

	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(chrichri, x, y, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (x >= PANEL_WIDTH - chrichri.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;

		if (y >= PANEL_HEIGHT - chrichri.getHeight(null) || y < 0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		repaint();

	}

}