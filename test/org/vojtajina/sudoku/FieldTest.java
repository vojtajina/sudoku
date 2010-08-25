package org.vojtajina.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	private IField field;
	
	@Before
	public void setUp() throws Exception {
		field = new Field(9);
	}
	
	@Test
	public void testGetChoicesSize() {
		assertEquals(9L, (long)field.getChoicesSize());
	}

	@Test
	public void testGetValue() {
		assertEquals(0L, (long)field.getValue());
	}

	@Test
	public void testIsSolved() {
		assertFalse(field.isSolved());
		field.setValue(1);
		assertTrue(field.isSolved());
	}

	@Test
	public void testSetValue() {
		assertEquals(0L, field.getValue());
		field.setValue(3);
		assertEquals(3L, field.getValue());
	}

	@Test
	public void testUnsetChoice() {
		assertTrue(field.unsetChoice(2));
		assertFalse(field.unsetChoice(2));
	}

	@Test
	public void testClone() {
		IField f = field.clone();
		f.setValue(3);
		assertFalse(field.isSolved());
	}
	
	@Test
	public void testGetSetIndex() {
		field.setIndex(10);
		assertEquals(10, field.getIndex());
	}

}
