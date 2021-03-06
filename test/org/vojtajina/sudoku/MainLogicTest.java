package org.vojtajina.sudoku;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MainLogicTest {
	private interface IMatrixModelField extends IMatrixModel<IField> {};
	private interface IUniqueCheckerInt extends IUniqueChecker<Integer> {};
	
	private MainLogic object;
	private IMatrixModel<IField> mockMatrix;
	private IUniqueChecker<Integer> mockChecker;
	private RowIndexConverter mockConverter;

	@Before
	public void setUp() throws Exception {
		mockMatrix = createMock(IMatrixModelField.class);
		mockChecker = createMock(IUniqueCheckerInt.class);
		mockConverter = createMock(RowIndexConverter.class);
		
		object = new MainLogic(null, mockMatrix, mockChecker, mockConverter, 9);
	}

	@Test
	public final void testCheckRowTrue() {
		checkRow(true);
	}
	
	@Test
	public final void testCheckRowFalse() {
		checkRow(false);
	}
	
	private void checkRow(boolean valid) {
		IField mockField = createMock(IField.class);
		
		// do not care about the order of calls
		expect(mockMatrix.get(2, 0)).andReturn(mockField);
		expect(mockMatrix.get(2, 1)).andReturn(mockField);
		expect(mockMatrix.get(2, 2)).andReturn(mockField);
		expect(mockMatrix.get(2, 3)).andReturn(mockField);
		expect(mockMatrix.get(2, 4)).andReturn(mockField);
		expect(mockMatrix.get(2, 5)).andReturn(mockField);
		expect(mockMatrix.get(2, 6)).andReturn(mockField);
		expect(mockMatrix.get(2, 7)).andReturn(mockField);
		expect(mockMatrix.get(2, 8)).andReturn(mockField);
		
		// field
		expect(mockField.getValue()).andReturn(0).times(8);
		expect(mockField.getValue()).andReturn(1);
		
		// unique checker
		mockChecker.reset();
		expect(mockChecker.check(1)).andReturn(valid);
		
		replay(mockMatrix);
		replay(mockChecker);
		replay(mockField);
		
		assertEquals(valid, object.checkRow(2));
		verify(mockChecker);
		verify(mockMatrix);
		verify(mockField);
	}

	@Test
	public final void testCheckColTrue() {
		checkCol(true);
	}
	
	@Test
	public final void testCheckColFalse() {
		checkCol(false);
	}
	
	private void checkCol(boolean valid) {
		IField mockField = createMock(IField.class);
		
		// do not care about the order of calls
		expect(mockMatrix.get(0, 1)).andReturn(mockField);
		expect(mockMatrix.get(1, 1)).andReturn(mockField);
		expect(mockMatrix.get(2, 1)).andReturn(mockField);
		expect(mockMatrix.get(3, 1)).andReturn(mockField);
		expect(mockMatrix.get(4, 1)).andReturn(mockField);
		expect(mockMatrix.get(5, 1)).andReturn(mockField);
		expect(mockMatrix.get(6, 1)).andReturn(mockField);
		expect(mockMatrix.get(7, 1)).andReturn(mockField);
		expect(mockMatrix.get(8, 1)).andReturn(mockField);
		
		// field
		expect(mockField.getValue()).andReturn(0).times(8);
		expect(mockField.getValue()).andReturn(1);
		
		// unique checker
		mockChecker.reset();
		expect(mockChecker.check(1)).andReturn(valid);
		
		replay(mockMatrix);
		replay(mockChecker);
		replay(mockField);
		
		assertEquals(valid, object.checkCol(1));
		verify(mockChecker);
		verify(mockMatrix);
		verify(mockField);
	}

	@Test
	public final void testCheckBoxTrue() {
		checkBox(true);
	}
	
	@Test
	public final void testCheckBoxFalse() {
		checkBox(false);
	}
	
	private void checkBox(boolean valid) {
		IField mockField = createMock(IField.class);
		
		// do not care about the order of calls
		expect(mockMatrix.get(0, 3)).andReturn(mockField);
		expect(mockMatrix.get(0, 4)).andReturn(mockField);
		expect(mockMatrix.get(0, 5)).andReturn(mockField);
		expect(mockMatrix.get(1, 3)).andReturn(mockField);
		expect(mockMatrix.get(1, 4)).andReturn(mockField);
		expect(mockMatrix.get(1, 5)).andReturn(mockField);
		expect(mockMatrix.get(2, 3)).andReturn(mockField);
		expect(mockMatrix.get(2, 4)).andReturn(mockField);
		expect(mockMatrix.get(2, 5)).andReturn(mockField);
		
		// field
		expect(mockField.getValue()).andReturn(0).times(8);
		expect(mockField.getValue()).andReturn(1);
		
		// unique checker
		mockChecker.reset();
		expect(mockChecker.check(1)).andReturn(valid);
		
		// converter
		expect(mockConverter.getRow(1, 3)).andReturn(0);
		expect(mockConverter.getCol(1, 3)).andReturn(1);
		
		replay(mockMatrix);
		replay(mockChecker);
		replay(mockField);
		replay(mockConverter);
		
		assertEquals(valid, object.checkBox(1));
		verify(mockChecker);
		verify(mockMatrix);
		verify(mockField);
	}

	@Test
	public final void testCheck() {
		fail("Not yet implemented"); // TODO
	}

}
