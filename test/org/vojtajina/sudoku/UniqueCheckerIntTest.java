package org.vojtajina.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniqueCheckerIntTest {
	
	private UniqueCheckerInt checker;

	@Before
	public void setUp() throws Exception {
		checker = new UniqueCheckerInt(9);
	}

	@Test
	public final void testCheck() {
		assertTrue(checker.check(1));
		assertTrue(checker.check(2));
		assertTrue(checker.check(3));
		assertFalse(checker.check(1));
	}

	@Test
	public final void testReset() {
		assertTrue(checker.check(1));
		checker.reset();
		assertTrue(checker.check(1));
	}

}
