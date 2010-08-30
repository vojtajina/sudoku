package org.vojtajina.sudoku;

public interface IUniqueChecker<T> {

	public void reset();
	public boolean check(T item);
}
