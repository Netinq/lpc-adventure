package fr.kent.lpcadventure.graph;

public class ImageTile extends Image
{
	
	private int tileW, tileH;
	
	public ImageTile(String path, int tileW, int tileH)
	{
		super(path, 0, 0);
		this.tileW = tileW;
		this.tileH = tileH;
	}

	public int getTileW() {
		return tileW;
	}

	public void setTileW(int tileW) {
		this.tileW = tileW;
	}

	public int getTileH() {
		return tileH;
	}

	public void setTileH(int tileH) {
		this.tileH = tileH;
	}
	
	

}
