package com.coelleonline.marsrover;

enum Direction {
	NORTH("N", "W", "E"),
	EAST("E", "N", "S"),
	SOUTH("S", "E", "W"),
	WEST("W", "S", "N");

	private final String value;
	private final String left;
	private final String right;

	Direction(String value, String left, String right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public String value() {
		return value;
	}

	public Direction left() {
		return directionMatching(left);
	}

	public Direction right() {
		return directionMatching(right);
	}

	private Direction directionMatching(String dir) {
		for (Direction direction : values()) {
			if (direction.value.equals(dir)) {
				return direction;
			}
		}
		throw new IllegalStateException("This should never happen: " + this.toString());
	}
}
