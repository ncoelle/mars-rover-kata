package com.coelleonline.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
