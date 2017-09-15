package com.coelleonline.marsrover;

class Rover {
	private String currentDirection = "N";

	String execute(String commandString) {
		final char[] commands = commandString.toCharArray();
		for (char command : commands) {
			currentDirection = rotateRight();
		}
		return "0:0:" + currentDirection;
	}

	private String rotateRight() {
		switch (currentDirection) {
			case "N":
				return "E";
			case "E":
				return "S";
			case "S":
				return "W";
			case "W":
				return "N";
			default:
				throw new IllegalArgumentException(currentDirection);
		}
	}
}
