package com.coelleonline.marsrover;

class Grid {
	private static final int MAX_HEIGHT = 10;
	private static final int MAX_WIDTH = 10;

	Coordinate nextCoordinateFor(Coordinate coordinate, Direction currentDirection) {
		int y = coordinate.y();
		int x = coordinate.x();
		if (currentDirection == Direction.NORTH) {
			y = (y + 1) % MAX_HEIGHT;
		}
		if (currentDirection == Direction.EAST) {
			x = (x + 1) % MAX_WIDTH;
		}
		if (currentDirection == Direction.SOUTH) {
			y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
		}
		if (currentDirection == Direction.WEST) {
			x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
		}
		return new Coordinate(x, y);
	}
}
