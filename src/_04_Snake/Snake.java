package _04_Snake;
//CONTINUE LINE 58
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		System.out.println("feed");
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {
		int nextX = head.getLocation().getX();
		int nextY = head.getLocation().getY();
		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */
		switch (currentDirection) {
		case UP:
			nextY--;
			break;
		case DOWN:
			nextY++;
			break;
		case LEFT:
			nextX--;
			break;
		case RIGHT:
			nextX++;
			break;
		}
		


		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
for(int i = 1;i<snake.size();i++) {
	snake.get(i).setLocation(snake.get(i-1).getLocation());
}
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */
head.setLocation(new Location(nextX,nextY));
	
		// Set the canMove member variable to true.
canMove=true;
	}

	public void setDirection(Direction direction) {
if(isNotOppositeDirection(direction)) {
	currentDirection=direction;
}
		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */

	}

	private boolean isNotOppositeDirection(Direction direction) {
		switch(currentDirection) {
		case UP:
			if(direction==Direction.DOWN) {
				return false;
			}
			break;
		case DOWN:
			if(direction==Direction.UP) {
				return false;
			}
			break;
		case LEFT:
			if(direction==Direction.RIGHT) {
				return false;
			}
			break;
		case RIGHT:
			if(direction==Direction.LEFT) {
				return false;
			}
			break;
			
		}
		return true;
		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */
	}

	public void resetLocation() {

		// Clear the snake.
		snake.clear();
		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */head.setLocation(new Location(SnakeGame.WIDTH/2,SnakeGame.HEIGHT/2));
		 snake.add(head);
		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */

		// Add the head to the snake.

	}

	public boolean isOutOfBounds() {

		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		if(head.getLocation().getX()<0||head.getLocation().getX()>SnakeGame.WIDTH||head.getLocation().getY()<0||head.getLocation().getY()>SnakeGame.HEIGHT) {
			return true;
		}
		return false;
	}

	public boolean isHeadCollidingWithBody() {
		for(int i = 1; i<snake.size();i++) {
			if(snake.get(i).getLocation().equals(head.getLocation())) {
				return true;
			}
			}
return false;
		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
	}

	public boolean isLocationOnSnake(Location loc) {
for(SnakeSegment s:snake) {
	if(s.getLocation().equals(loc)) {
		return true;
	}
}
		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */

		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
