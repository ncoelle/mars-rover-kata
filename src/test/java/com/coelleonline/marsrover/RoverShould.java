package com.coelleonline.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RoverShould {

	private Rover rover;

	@BeforeEach
	void setUp() {
		rover = new Rover();
	}

	@ParameterizedTest
	@CsvSource({
			"R, 0:0:E",
			"RR, 0:0:S",
			"RRR, 0:0:W",
			"RRRR, 0:0:N",
			"RRRRR, 0:0:E"
	})
	void rotate_right(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"L, 0:0:W",
			"LL, 0:0:S",
			"LLL, 0:0:E",
			"LLLL, 0:0:N",
			"LLLLL, 0:0:W",
	})
	void rotate_left(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"M, 0:1:N",
			"MMMMM, 0:5:N",
			"MMMMMMMMM, 0:9:N",
	})
	void move_up(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"MMMMMMMMMM, 0:0:N",
			"MMMMMMMMMMMMMMM, 0:5:N",
	})
	void wrap_from_top_to_bottom_when_moving_north(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"RM, 1:0:E",
			"RMMMMM, 5:0:E",
			"RMMMMMMMMM, 9:0:E",
	})
	void move_right(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"RMMMMMMMMMM, 0:0:E",
			"RMMMMMMMMMMMMMMM, 5:0:E",
	})
	void wrap_from_right_to_left_when_moving_east(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"LM, 9:0:W",
			"LMMMMM, 5:0:W",
			"LMMMMMMMMMM, 0:0:W",
	})
	void move_left(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"LLM, 0:9:S",
			"LLMMMMM, 0:5:S",
			"LLMMMMMMMMMM, 0:0:S",
	})
	void move_down(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}

	@ParameterizedTest
	@CsvSource({
			"MMMMM, 0:3:N",
			"RMMMMMMM, 1:0:E",
	})
	void stop_at_obstacle(String commands, String position) {
		final Coordinate obstacle_0x4 = new Coordinate(0, 4);
		final Coordinate obstacle_2x0 = new Coordinate(2, 0);
		final Grid grid = new Grid(asList(obstacle_0x4, obstacle_2x0));
		final Rover rover = new Rover(grid);
		assertThat(rover.execute(commands), is(position));
	}
}
