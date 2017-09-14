package com.coelleonline.marsrover;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RoverShould {
	@Test
	void rotate_right() {
		Rover rover = new Rover();
		assertThat(rover.execute("R"), is("0:0:E"));
	}
}
