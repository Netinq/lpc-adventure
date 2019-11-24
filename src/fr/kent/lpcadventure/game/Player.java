package fr.kent.lpcadventure.game;

import fr.kent.lpcadventure.engine.GameContainer;
import fr.kent.lpcadventure.engine.Renderer;
import fr.kent.lpcadventure.graph.Image;

public class Player extends GameObject {
	
	private Image image;
	
	public Player(int posX, int posY)
	{
		this.tag = "player";
		this.posX = posX * 16;
		this.posY = posY * 16;
		this.width = 16;
		this.height = 16;
		
		image = new Image("/caracters/player.png", this.width, this.height);
	}

	@Override
	public void update(GameContainer c, int dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer c, Renderer r) {
		r.drawImage(image, posX, posY);
	}

}
