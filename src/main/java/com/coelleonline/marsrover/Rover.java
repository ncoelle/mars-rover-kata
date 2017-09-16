package com.coelleonline.marsrover;

class Rover {
	private static final int INITIAL_X = 0;
	private static final int INITIAL_Y = 0;
	private static final int MAX_HEIGHT = 10;
	private static final int MAX_WIDTH = 10;

	private Direction currentDirection = Direction.NORTH;
	private Coordinate coordinate = new Coordinate(INITIAL_X, INITIAL_Y);

	String execute(String commandString) {
		final char[] commands = commandString.toCharArray();
		for (char command : commands) {
			if (command == 'R') {
				currentDirection = currentDirection.right();
			}
			if (command == 'L') {
				currentDirection = currentDirection.left();
			}
			if (command == 'M') {
				coordinate = move();
			}
		}
		return coordinate.x() + ":" + coordinate.y() + ":" + currentDirection.value();
	}

	private Coordinate move() {
		int y = coordinate.y();
		int x = coordinate.x();
		if (currentDirection == Direction.NORTH) {
			y = (y + 1) % MAX_HEIGHT;
		}
		if (currentDirection == Direction.EAST) {
			x = (x + 1) % MAX_WIDTH;
		}
		return new Coordinate(x, y);
	}
}
