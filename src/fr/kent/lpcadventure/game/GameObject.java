package fr.kent.lpcadventure.game;

import fr.kent.lpcadventure.engine.GameContainer;
import fr.kent.lpcadventure.engine.Renderer;

public abstract class GameObject {
	
	protected String tag;
	protected int posX, posY;
	protected int width, height;
	protected boolean dead = false;
	
	public abstract void update(GameContainer c, int dt);
	public abstract void render(GameContainer c, Renderer r);
	
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
