package fr.heighties.testdeplacementschrichri;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 204477141609855149L;

	public static final int WIDTH = 800, HEIGHT = 600;
	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 600;
	Image chrichri;
	Image backgroundImage;
	private Thread thread;
	private boolean running = false;
	private Handler handler;

	public enum STATE {
		Menu, Help, Game, End

	};

	public static STATE gameState = STATE.Menu;

	public Game() {

		handler = new Handler();

		this.addKeyListener(new KeyInput(handler));

		// new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);

		if (gameState == STATE.Game) {

			handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));

		}

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// pas besoin de cliquer sur fenetre pour jouer :
		this.requestFocus();
		//
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();

	}

	private void tick() {
		handler.tick();
		if (gameState == STATE.Game)
			;

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
	}
	// Graphics g = bs.getDrawGraphics();

	// g.setColor(Color.black);
	// g.fillRect(0, 0, WIDTH, HEIGHT);

	// handler.render(g);}
	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(backgroundImage, 0, 0, null);

		/*
		 * if (gameState == STATE.Game) {
		 * 
		 * hud.render(g); } else if (gameState == STATE.Menu || gameState == STATE.Help
		 * || gameState == STATE.End) { // menu.render(g); }
		 * 
		 * g.dispose(); bs.show();
		 * 
		 * }
		 */}

	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;

	}

}