package org.vojtajina.sudoku;

import javax.swing.JFrame;
import javax.swing.table.TableModel;

public class Start {

	/**
	 * Start point of the application
	 * @param args
	 */
	public static void main(String[] args) {

		int size = 9;

		IFieldValidator fv = new FieldValidator(size);
		MatrixModel m = new MatrixModel(new Field(size), new RowIndexConverter(size), fv, size);
		JFrame form = new MainForm((TableModel)m);
		IUniqueChecker<Integer> ch = new UniqueCheckerInt(size);
		
		@SuppressWarnings("unused")
		MainLogic app = new MainLogic((IMainView) form, (IMatrixModel<IField>) m, ch);
		form.setVisible(true);
	}

}
