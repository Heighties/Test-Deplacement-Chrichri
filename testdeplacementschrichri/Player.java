package fr.heighties.testdeplacementschrichri;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	MyPanel panel;
	Image chrichri;

	Random r = new Random();
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	// colisions

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
//
	}

	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);

		// pour avoir la "trainée" qui suit le joueur

//
		collision();

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			// HUD.HEALTH -= 2;
		}

	}

	public void paint(Graphics2D g) {

		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;

		// g.setColor(Color.white);
		g2D.drawImage(chrichri, x, y, null);

		// g.fillRect((int) x, (int) y, 32, 32);

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}