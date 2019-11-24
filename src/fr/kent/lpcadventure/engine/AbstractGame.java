package fr.kent.lpcadventure.engine;

public abstract class AbstractGame {
	
	public abstract void update(GameContainer c, int dt);
	public abstract void render(GameContainer c, Renderer r);
}
