package org.vojtajina.sudoku;

import java.util.List;
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
		
		@SuppressWarnings("unused")
		MainLogic app = new MainLogic((IMainView) form, (List<IField>) m, fv);
		form.setVisible(true);
	}

}
