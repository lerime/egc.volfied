import java.awt.event.KeyEvent;


public class Point {

	int x;
	int y;

	public Point() {}
	public Point(int p_x, int p_y) {
		this.x = p_x;
		this.y = p_y;
	}
	
	public void rotatePoint(double angle) {
		int old_x = x;
		int old_y = y;
		x = (int) (old_x * Math.cos(Math.toRadians(angle)) - old_y * Math.sin(Math.toRadians(angle))); 
		y = (int) (old_x * Math.sin(Math.toRadians(angle)) + old_y * Math.cos(Math.toRadians(angle)));
	}

	@Override
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ")";
	}

	/*
	 * Returns the new position considering that the player would move
	 * according to the key pressed.
	 */
	public Point getNewPosition(int keyCode, int pase)
	{
		int diff_x = 0;
		int diff_y = 0;

		switch (keyCode) {
		case KeyEvent.VK_UP:
			diff_x = 0;
			diff_y = -pase;
			Volfied.player.orientation = Volfied.player.UP;
			break;
		case KeyEvent.VK_DOWN:
			diff_x = 0;
			diff_y = pase;
			Volfied.player.orientation = Volfied.player.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			diff_x = -pase;
			diff_y = 0;
			Volfied.player.orientation = Volfied.player.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			diff_x = pase;
			diff_y = 0;
			Volfied.player.orientation = Volfied.player.RIGHT;
			break;
		case KeyEvent.VK_SPACE:
			Volfied.player.shoot();
		default:
			/* ignore random key presses: the new position is the same as the current one */
			break;
		}
		return new Point(this.x + diff_x, this.y + diff_y);
	}
	

	public Point getShipNewPosition(int direction, int pase)
	{
		int diff_x = 0;
		int diff_y = 0;

		switch (direction) {
		case Ship.NORTH:
			diff_x = 0;
			diff_y = -pase;
			break;
		case Ship.SOUTH:
			diff_x = 0;
			diff_y = pase;
			break;
		case Ship.WEST:
			diff_x = -pase;
			diff_y = 0;
			break;
		case Ship.EAST:
			diff_x = pase;
			diff_y = 0;
			break;
		case Ship.NEAST:
			diff_x = pase;
			diff_y = -pase;
			break;
		case Ship.NWEST:
			diff_x = -pase;
			diff_y = -pase;
			break;
		case Ship.SEAST:
			diff_x = pase;
			diff_y = pase;
			break;
		case Ship.SWEST:
			diff_x = -pase;
			diff_y = pase;
			break;
			
		default:
			/* ignore random key presses: the new position is the same as the current one */
			break;
		}
		return new Point(this.x + diff_x, this.y + diff_y);
	}
	
	public Point getBombNewPosition(int direction, int pase) {
		int diff_x = 0;
		int diff_y = 0;

		switch (direction) {
		case Ship.NORTH:
			diff_x = 0;
			diff_y = -pase;
			break;
		case Ship.SOUTH:
			diff_x = 0;
			diff_y = pase;
			break;
		case Ship.WEST:
			diff_x = -pase;
			diff_y = 0;
			break;
		case Ship.EAST:
			diff_x = pase;
			diff_y = 0;
			break;
		}
		return new Point(this.x + diff_x, this.y + diff_y);
	}
	
	public boolean equals(Point p)
	{
		return p.x == x && p.y == y;
	}


	public int dist(Point p)
	{
		// this is only valid for horizontal/vertical lines
		// This works because one coord. is constant =>
		// the length is the difference of the other two coords.
		return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);

	}
}
