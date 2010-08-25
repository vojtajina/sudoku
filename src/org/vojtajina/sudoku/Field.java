package org.vojtajina.sudoku;

import java.util.ArrayList;

public class Field implements IField {

	private ArrayList<Integer> choices;
	private int index;
	
	public Field(int range) {
		choices = new ArrayList<Integer>(range);
		for (int i = 1; i <= range; i++)
			choices.add(i);
	}
	
	private Field() {
	}
	
	@Override
	public int getChoicesSize() {
		return choices.size();
	}

	@Override
	public int getValue() {
		if (choices.size() == 1)
			return choices.get(0);

		return 0;
	}

	@Override
	public boolean isSolved() {
		return choices.size() == 1;
	}

	@Override
	public void setValue(int val) {
		choices.clear();
		choices.add(val);
	}

	@Override
	public boolean unsetChoice(int val) {
		if (choices.contains(val)) {
			choices.remove((Integer)val);
			return true;
		}

		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IField clone() {
		Field field = new Field();
		field.choices = (ArrayList<Integer>) choices.clone();

		return field;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public void setIndex(int idx) {
		index = idx;
	}

}
