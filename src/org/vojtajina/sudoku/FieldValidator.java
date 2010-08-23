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
		try {
			int val = Integer.parseInt(input);
			
			if (val > 0 && val <= range) {
				value = val;
				return true;
			}
		}
		catch (NumberFormatException e) {
		}
		
		value = 0;
		return false;
	}

}
