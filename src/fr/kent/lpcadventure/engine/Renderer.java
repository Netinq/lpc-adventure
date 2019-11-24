// VIDEO 6 5 minutes 48 !!

package fr.kent.lpcadventure.engine;

import java.awt.image.DataBufferInt;

import fr.kent.lpcadventure.graph.Font;
import fr.kent.lpcadventure.graph.Image;
import fr.kent.lpcadventure.graph.ImageTile;




public class Renderer 
{
	private int width, height;
	private int[] p;
	
	private Font font;
	
	public Renderer(GameContainer gc)
	{
		width = gc.getWidth();
		height = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++)
		{
			p[i] = 0;
		}
	}
	
	public void setPixel(int x, int y , int value)
	{
		if ((x < 0 || x >= width || y < 0 || y >= height) || value == 0xffff00ff)
		{
			return;
		}
		
		p[x + y * width] = value;
				
	}
	
	public void drawText(String texte, int offX, int offY, int color)
	{
		int offset = 0;
		
		for (int i = 0; i < texte.length(); i++)
		{
			int unicode = texte.codePointAt(i) - 32;
			for (int y = 0; y < font.getFontImage().getHeight(); y++)
			{
				for (int x = 0; x < font.getWidths()[unicode]; x++)
				{
					if (font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getWidth()] == 0xffffffff)
					{
						setPixel(x + offX + offset, y + offY, color);
					}
				}
			}
		}
	}
	
	public void drawImage(Image image, int offX, int offY)
	{

		if (offX < -image.getWidth()) return;
		if (offY < -image.getHeight()) return;
		if (offX >= width) return;
		if (offY >= height) return;
		
		//
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();

		
		//
		
		if(offX < 0){newX -= offX;}
		if(offY < 0){newY -= offY;}
		
		
		
		if (newWidth + offX >= width) {newWidth -= newWidth + offX - width;}
		if (newHeight + offY >= height) {newHeight -= newHeight + offY - height;}
		
		for(int y = newY; y < newHeight; y++)
		{
			for(int x= newX; x < newWidth; x++)
			{
				setPixel(x + offX,y + offY, image.getP()[x + y * image.getWidth()]);
			}
		}
	}
	
	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) 
	{
		if (offX < -image.getTileW()) return;
		if (offY < -image.getTileH()) return;
		if (offX >= width) return;
		if (offY >= height) return;
		
		//
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileW();
		int newHeight = image.getTileH();

		
		//
		
		if(offX < 0){newX -= offX;}
		if(offY < 0){newY -= offY;}
		
		
		
		if (newWidth + offX >= width) {newWidth -= newWidth + offX - width;}
		if (newHeight + offY >= height) {newHeight -= newHeight + offY - height;}
		
		for(int y = newY; y < newHeight; y++)
		{
			for(int x= newX; x < newWidth; x++)
			{
				setPixel(x + offX,y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + image.getTileH()) * image.getWidth()]);
			}
		}
	}
}
