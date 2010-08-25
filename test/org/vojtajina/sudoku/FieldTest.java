package org.vojtajina.sudoku;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	@Test
	public void testAddListener() {
		ActionListener mockListener = createMock(ActionListener.class);
		field.addActionListener(mockListener);
		mockListener.actionPerformed(anyObject(ActionEvent.class));
		replay(mockListener);
		
		// do nothing - no value change
		field.unsetChoice(1);
		field.unsetChoice(2);
		
		// only one change
		field.setValue(3);
		field.setValue(3);
	}
	
	@Test
	public void testFireEvent() {
		ActionListener mockListener = createMock(ActionListener.class);
		field.addActionListener(mockListener);
		mockListener.actionPerformed(anyObject(ActionEvent.class));
		expectLastCall().times(2);
		replay(mockListener);
		
		// two changes
		field.setValue(3);
		field.setValue(4);
	}
	
	@Test
	public void testRemoveListener() {
		ActionListener mockListener = createMock(ActionListener.class);
		field.addActionListener(mockListener);
		field.removeActionListener(mockListener);
		replay(mockListener);
		field.setValue(3);
	}

}
