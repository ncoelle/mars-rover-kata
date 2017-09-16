package com.coelleonline.marsrover;

import java.util.Collections;
import java.util.Optional;

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
		String obstacleString = "";
		for (char command : commands) {
			if (command == 'R') {
				currentDirection = currentDirection.right();
			}
			if (command == 'L') {
				currentDirection = currentDirection.left();
			}
			if (command == 'M') {
				obstacleString = move();
			}
		}
		return obstacleString + coordinate.x() + ":" + coordinate.y() + ":" + currentDirection.value();
	}

	private String move() {
		Optional<Coordinate> nextCoordinate = grid.nextCoordinateFor(coordinate, currentDirection);
		nextCoordinate.ifPresent(co -> this.coordinate = co);
		String obstacleString = nextCoordinate.isPresent() ? "" : "O:";
		return obstacleString;
	}
}
