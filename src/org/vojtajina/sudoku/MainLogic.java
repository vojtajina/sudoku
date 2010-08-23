package org.vojtajina.sudoku;

import java.util.List;

/**
 * Main logic of the application
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class MainLogic {
	
	private IMainView view;
	private List<IField> fields;
	private IFieldValidator validator;
	
	public MainLogic(IMainView view, List<IField> fields, IFieldValidator validator) {
		this.view = view;
		this.fields = fields;
		this.validator = validator;
	}

}
