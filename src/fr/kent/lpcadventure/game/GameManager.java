package fr.kent.lpcadventure.game;

import java.io.IOException;
import java.util.ArrayList;

import fr.kent.lpcadventure.engine.AbstractGame;
import fr.kent.lpcadventure.engine.GameContainer;
import fr.kent.lpcadventure.engine.Renderer;
import fr.kent.lpcadventure.graph.ImageTile;

public class GameManager extends AbstractGame {
	
	private int[] collision;
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	private ImageTile image;
	
	public GameManager()
	{
		objects.add(new Player(2, 2));
		image = new ImageTile("/test.png", 16, 16);
	}

	@Override
	public void update(GameContainer c, int dt) 
	{
		for (int i = 0; i < objects.size(); i++)
		{
			objects.get(i).update(c, dt);
			if (objects.get(i).isDead())
			{
				objects.remove(i);
				i--;
			}
		}
		
		temp += dt * 20;
		
		if(temp > 3) {
			
			temp = 0;
		}
	}

	float temp = 0; 
	
	@Override
	public void render(GameContainer c, Renderer r) 
	{
		for (GameObject obj : objects)
		{
			obj.render(c, r);
			r.drawImageTile(image,c.getInput().getMouseX() -32 , c.getInput().getMouseY() -32 , (int)temp, 0);
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}

}
