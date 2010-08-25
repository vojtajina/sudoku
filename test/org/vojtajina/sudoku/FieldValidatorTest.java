package org.vojtajina.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldValidatorTest {

	private IFieldValidator fv;
	
	@Before
	public void setUp() throws Exception {
		fv = new FieldValidator(9);
	}
	
	@Test
	public void testComplex() {
		assertEquals(0L, fv.getCleanValue());
		assertFalse(fv.validate("0"));
		assertEquals(0L, fv.getCleanValue());
		assertTrue(fv.validate("1"));
		assertEquals(1L, fv.getCleanValue());
		assertFalse(fv.validate("10"));
		assertEquals(0L, fv.getCleanValue());
		assertFalse(fv.validate("e1"));
		assertEquals(0L, fv.getCleanValue());
	}

}
