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
			"R, 0:0:E"
	})
	void rotate_right(String commands, String position) {
		assertThat(rover.execute(commands), is(position));
	}
}
