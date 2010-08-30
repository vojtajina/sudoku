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
	private int size;
	
	public MainLogic(IMainView view, IMatrixModel<IField> fields, IUniqueChecker<Integer> checker, int size) {
		view.addListener(this);
		
		this.view = view;
		this.fields = fields;
		this.checker = checker;
		this.size = size;
	}

	@Override
	public void solveClick(MouseEvent e) {
//		view.setEnabled(false);
//		fields.get(1).setValue(2);
//		fields.get(4).setValue(5);
		System.out.print("SOLVE");
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
		return false;
	}
	
	public boolean check() {
		return false;
	}

}
