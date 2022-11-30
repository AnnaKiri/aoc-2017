package Day3;

public class Pointer {
	private int x;
	private int y;
	
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void moveToRight() {
	     y++;
	}

	public void moveToLeft() {
	     y--;
	}

	public void moveToUp() {
	     x--;
	}

	public void moveToDown() {
	     x++;
	}
	
	public String getCoordString() {
		return x + ";" + y;
	}
}
