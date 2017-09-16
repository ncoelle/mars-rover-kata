package com.coelleonline.marsrover;

import java.util.Collections;

class Rover {
	private static final int INITIAL_X = 0;
	private static final int INITIAL_Y = 0;

	private final Grid grid;
	private Direction currentDirection = Direction.NORTH;
	private Coordinate coordinate = new Coordinate(INITIAL_X, INITIAL_Y);

	Rover() {
		this(new Grid(Collections.emptyList()));
	}

	Rover(Grid grid) {
		this.grid = grid;
	}

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
				coordinate = grid.nextCoordinateFor(coordinate, currentDirection);
			}
		}
		return coordinate.x() + ":" + coordinate.y() + ":" + currentDirection.value();
	}
}
