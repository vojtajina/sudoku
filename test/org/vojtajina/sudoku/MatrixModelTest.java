package org.vojtajina.sudoku;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.junit.Before;
import org.junit.Test;

public class MatrixModelTest {

	private MatrixModel model;
	private IFieldValidator validator;
	private RowIndexConverter converter;
	
	@Before
	public void setUp() throws Exception {
		validator = createMock(IFieldValidator.class);
		converter = createMock(RowIndexConverter.class);
		model = new MatrixModel(new Field(9), converter, validator, 9);
	}

	@Test
	public void testGetColumnCount() {
		assertEquals(9L, model.getColumnCount());
	}

	@Test
	public void testGetRowCount() {
		assertEquals(9L, model.getRowCount());
	}

	@Test
	public void testGetValueAt() {
		expect(converter.getIndex(anyInt(), anyInt())).andReturn(0).anyTimes();
		expect(converter.getRow(anyInt())).andReturn(0).anyTimes();
		expect(converter.getCol(anyInt())).andReturn(0).anyTimes();
		replay(converter);
		
		assertNull(model.getValueAt(0, 0));
		model.get(0, 0).setValue(3);
		assertEquals(3, model.getValueAt(0, 0));
	}

	@Test
	public void testFireTableCellUpdated() {
		expect(converter.getRow(anyInt())).andStubReturn(0);
		expect(converter.getCol(anyInt())).andStubReturn(0);
		expect(converter.getIndex(0, 0)).andReturn(0);
		
		TableModelListener mockListener = createMock(TableModelListener.class);
		mockListener.tableChanged(anyObject(TableModelEvent.class));
		model.addTableModelListener(mockListener);
		
		replay(mockListener);
		replay(converter);
		model.get(0,0).setValue(2);
		
		verify(mockListener);
	}
	
	@Test
	public void testIsCellEditable() {
		for (int i = 0; i < 9; i++)
			for (int x = 0; x < 9; x++)
				assertTrue(model.isCellEditable(i, x));		
	}
	
	@Test
	public void testSetValueAt() {
		expect(converter.getRow(anyInt())).andReturn(0);
		expect(converter.getCol(anyInt())).andReturn(0);
		expect(converter.getIndex(anyInt(), anyInt())).andReturn(0).anyTimes();
		expect(validator.validate(anyObject(String.class))).andReturn(true);
		expect(validator.getCleanValue()).andReturn(1);
		replay(converter);
		replay(validator);
		
		IField f = model.get(0, 0);
		model.setValueAt("1", 0, 0);
		assertEquals(1, f.getValue());
	}

}
