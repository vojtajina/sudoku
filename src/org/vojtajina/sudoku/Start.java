package org.vojtajina.sudoku;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Start {

	/**
	 * Start point of the application
	 * @param args
	 */
	public static void main(String[] args) {
		
		int size = 9;
		TableModel tm = new DefaultTableModel(size, size);
		JFrame form = new MainForm(tm);
		
		@SuppressWarnings("unused")
		Matrix app = new Matrix(tm, (IMainView)form);
		form.setVisible(true);
	}

}
