package org.vojtajina.sudoku;

import java.util.ArrayList;

public class Field implements IField {

	private ArrayList<Integer> choices; 
	
	public Field(int range) {
		choices = new ArrayList<Integer>(range);
		for (int i = 1; i <= range; i++)
			choices.add(i);
	}
	
	@Override
	public int getChoicesSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(int val) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean unsetChoice(int val) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public IField clone() {
		// TODO implement
		return this;
	}

}
