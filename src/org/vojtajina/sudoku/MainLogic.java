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
	
	public MainLogic(IMainView view, IMatrixModel<IField> fields, IUniqueChecker<Integer> checker) {
		view.addListener(this);
		
		this.view = view;
		this.fields = fields;
		this.checker = checker;
	}

	@Override
	public void solveClick(MouseEvent e) {
//		view.setEnabled(false);
//		fields.get(1).setValue(2);
//		fields.get(4).setValue(5);
		System.out.print("SOLVE");
	}
	
	public boolean checkRow(int row) {
		return false;
	}
	
	public boolean checkCol(int col) {
		return false;
	}
	
	public boolean checkBox(int box) {
		return false;
	}
	
	public boolean check() {
		return false;
	}

}
