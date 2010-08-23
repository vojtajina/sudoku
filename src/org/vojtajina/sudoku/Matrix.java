package org.vojtajina.sudoku;

import javax.swing.table.TableModel;

/**
 * Represents whole sudoku matrix
 * Main logic of the application
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class Matrix {
	
	private TableModel tableModel = null;
	private IMainView mainView = null;
	
	public Matrix(TableModel tm, IMainView v) {
		tableModel = tm;
		mainView = v;
	}

}
