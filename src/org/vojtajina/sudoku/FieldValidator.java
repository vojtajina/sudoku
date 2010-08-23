package org.vojtajina.sudoku;

public class FieldValidator implements IFieldValidator {

	private int range;
	private int value;
	
	public FieldValidator(int range) {
		this.range = range;
	}
	
	@Override
	public int getCleanValue() {
		return value;
	}

	@Override
	public boolean validate(String input) {
		// TODO Auto-generated method stub
		return false;
	}

}
