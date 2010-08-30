package org.vojtajina.sudoku;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Main logic of the application
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class MainLogic implements IMainViewListener {
	
	private IMainView view;
	private List<IField> fields;
	private IFieldValidator validator;
	
	public MainLogic(IMainView view, List<IField> fields, IFieldValidator validator) {
		view.addListener(this);
		
		this.view = view;
		this.fields = fields;
		this.validator = validator;
	}

	@Override
	public void solveClick(MouseEvent e) {
//		view.setEnabled(false);
		fields.get(1).setValue(2);
		fields.get(4).setValue(5);
		System.out.print("SOLVE");
	}

}
