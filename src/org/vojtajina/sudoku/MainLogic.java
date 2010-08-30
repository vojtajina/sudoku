package org.vojtajina.sudoku;

import java.awt.event.MouseEvent;

/**
 * Main logic of the application
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class MainLogic implements IMainViewListener {
	
	private IMainView view;
	private IMatrixModel<IField> fields;
	private IUniqueChecker<Integer> checker;
	private RowIndexConverter converter;
	private int size;
	
	public MainLogic(IMainView view, IMatrixModel<IField> fields, IUniqueChecker<Integer> checker, RowIndexConverter converter, int size) {		
		this.view = view;
		this.fields = fields;
		this.checker = checker;
		this.converter = converter;
		this.size = size;
	}

	@Override
	public void solveClick(MouseEvent e) {
		view.setEnabled(false);
		if (check())
			view.alert("IS VALID");
		else
			view.alert("ERRORS");
		view.setEnabled(true);
	}
	
	public boolean checkRow(int row) {
		int value;
		boolean isValid = true;
		checker.reset();
		
		for (int col = 0; col < size; col++) {
			value = fields.get(row, col).getValue();
			
			if (value > 0 && !checker.check(value))
				isValid = false;
		}
		
		return isValid;
	}
	
	public boolean checkCol(int col) {
		int value;
		boolean isValid = true;
		checker.reset();
		
		for (int row = 0; row < size; row++) {
			value = fields.get(row, col).getValue();
			
			if (value > 0 && !checker.check(value))
				isValid = false;
		}
		
		return isValid;
	}
	
	public boolean checkBox(int box) {
		int value;
		boolean isValid = true;
		checker.reset();
		
		int boxSize = (int)Math.sqrt(size);
		int rowBase = converter.getRow(box, boxSize);
		int colBase = converter.getCol(box, boxSize);
		
		rowBase = rowBase * boxSize;
		colBase = colBase * boxSize;
		
		for (int a = 0; a < boxSize; a++)
			for (int b = 0; b < boxSize; b++) {
				value = fields.get(rowBase + a, colBase + b).getValue();
				
				if (value > 0 && !checker.check(value))
					isValid = false;
			}
		
		return isValid;
	}
	
	public boolean checkRows() {
		boolean isValid = true;
		
		for (int i = 0; i < size; i ++)
			if (!checkRow(i))
				isValid = false;
		
		return isValid;
	}
	
	public boolean checkCols() {
		boolean isValid = true;
		
		for (int i = 0; i < size; i ++)
			if (!checkCol(i))
				isValid = false;
		
		return isValid;
	}
	
	public boolean checkBoxes() {
		boolean isValid = true;
		
		for (int i = 0; i < size; i ++)
			if (!checkBox(i))
				isValid = false;
		
		return isValid;
	}
	
	public boolean check() {
		return checkRows() && checkCols() && checkBoxes();
	}

}
