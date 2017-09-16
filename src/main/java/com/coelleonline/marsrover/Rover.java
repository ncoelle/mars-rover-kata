package com.coelleonline.marsrover;

class Rover {
	private static final int INITIAL_X = 0;
	private static final int INITIAL_Y = 0;
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
		if (currentDirection == Direction.NORTH) {
			y = (y + 1) % 10;
		}
		return new Coordinate(coordinate.x(), y);
	}
}
