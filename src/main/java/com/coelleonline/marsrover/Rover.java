package com.coelleonline.marsrover;

class Rover {
	private Direction currentDirection = Direction.NORTH;

	String execute(String commandString) {
		final char[] commands = commandString.toCharArray();
		for (char command : commands) {
			if (command == 'R') {
				currentDirection = currentDirection.right();
			}
			if (command == 'L') {
				currentDirection = currentDirection.left();
			}
		}
		return "0:0:" + currentDirection.value();
	}
}
