package com.coelleonline.marsrover;

class Rover {
	private Direction currentDirection = Direction.NORTH;
	private int x = 0;
	private int y = 0;

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
				y++;
			}
		}
		return x + ":" + y + ":" + currentDirection.value();
	}
}
