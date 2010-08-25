package org.vojtajina.sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Field implements IField {

	private LinkedList<ActionListener> listeners;
	private ArrayList<Integer> choices;
	private int index;
	
	public Field(int range) {
		listeners = new LinkedList<ActionListener>();
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
		int oldVal = getValue();
		choices.clear();
		choices.add(val);
		
		if (getValue() != oldVal) {
			fireValueChanged();
		}
	}

	@Override
	public boolean unsetChoice(int val) {
		if (choices.contains(val)) {
			choices.remove((Integer)val);
			
			if (isSolved()) {
				fireValueChanged();
			}
			
			return true;
		}

		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IField clone() {
		Field field = new Field();
		field.choices = (ArrayList<Integer>) choices.clone();
		field.listeners = (LinkedList<ActionListener>) listeners.clone();
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

	@Override
	public void addActionListener(ActionListener l) {
		listeners.add(l);
	}

	@Override
	public void removeActionListener(ActionListener l) {
		listeners.remove(l);
		return;
	}
	
	protected void fireValueChanged() {
		Iterator<ActionListener> i = listeners.iterator();
		ActionEvent e = new ActionEvent(this, 0, "");
		
		while (i.hasNext())
			i.next().actionPerformed(e);
	}

}
