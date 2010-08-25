package org.vojtajina.sudoku;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RowIndexConverterTest {
	
	private RowIndexConverter converter;

	@Before
	public void setUp() throws Exception {
		converter = new RowIndexConverter(9);
	}

	@Test
	public final void testGetRow() {
		assertEquals(0, converter.getRow(0));
		assertEquals(0, converter.getRow(1));
		assertEquals(0, converter.getRow(8));
		assertEquals(1, converter.getRow(9));
	}
	
	@Test
	public final void testGetCol() {
		assertEquals(0, converter.getCol(0));
		assertEquals(1, converter.getCol(1));
		assertEquals(8, converter.getCol(8));
		assertEquals(0, converter.getCol(9));
	}

	@Test
	public final void testGetIndex() {
		assertEquals(0, converter.getIndex(0, 0));
		assertEquals(1, converter.getIndex(0, 1));
		assertEquals(2, converter.getIndex(0, 2));
		assertEquals(9, converter.getIndex(1, 0));
		assertEquals(10, converter.getIndex(1, 1));
	}

}
