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
		RowIndexConverter c = new RowIndexConverter(size);
		MatrixModel m = new MatrixModel(new Field(size), c, fv, size);
		IMainView form = new MainForm((TableModel)m);
		IUniqueChecker<Integer> ch = new UniqueCheckerInt(size);
		
		MainLogic app = new MainLogic(form, (IMatrixModel<IField>) m, ch, c, size);
		form.addListener(app);
		((JFrame)form).setVisible(true);
	}

}
