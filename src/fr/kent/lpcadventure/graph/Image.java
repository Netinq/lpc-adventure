package fr.kent.lpcadventure.graph;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	private int width, height;
	private int[] p;

	public Image(String path, int width, int height)
	{
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(Image.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (width == 0) width = image.getWidth();
		if (height == 0) height = image.getHeight();
		p = image.getRGB(0, 0, width, height, null, 0, width);
		
		image.flush();
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

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

}
