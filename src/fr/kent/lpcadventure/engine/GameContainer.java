package fr.kent.lpcadventure.engine;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;

import fr.kent.lpcadventure.game.GameObject;

public class GameContainer implements Runnable
{

	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Input input;
	private float scale = 1f;
	private AbstractGame game;
	
	private String title = "LPC Adventure";
	
	private boolean running = false;
	private final int UPDATE_CAP = 1/(60 / 60);

	private int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public GameContainer(AbstractGame game)
	{
		this.game = game;
	}

	public void start() throws IOException
	{
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
	}

	public void stop()
	{
		
	}
	
	public void run()
	{
		running = true;
		
		boolean render = false;
		long lastTime = System.currentTimeMillis();
		long currentTime, passedTime, unprocessedTime = 0, frameTime = 0, frames = 0, fps;
			
		while(running)
		{
			
			currentTime = System.currentTimeMillis();
			passedTime = currentTime - lastTime;
			lastTime = currentTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP)
			{
				unprocessedTime -= UPDATE_CAP;
				render = true;
				
				game.update(this, UPDATE_CAP);
				input.update();
				
				if (frameTime >= 1)
				{
					frameTime = 0;
					fps = frames;
					frames = 0;
				}
			}
			
			if (render)
			{
				renderer.clear();
				game.render(this, renderer);
				window.update();
				frames++;
				
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void dispose()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Window getWindow() {
		return window;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public Input getInput() {
		return input;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
		
	}
}