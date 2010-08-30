package org.vojtajina.sudoku;

/**
 * This class provides some basic methods
 * for converting indexes to rows and cells
 * 
 * As table addresses fields by row and cell number,
 * but in the list, they are stored using indexes.
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class RowIndexConverter {
	
	private int size;
	
	public RowIndexConverter(int size) {
		setBase(size);
	}
	
	public int getRow(int index) {
		return (int) Math.floor(index / size);
	}
	
	public int getCol(int index) {
		return index % size;
	}
	
	public int getIndex(int row, int col) {
		return row * size + col;
	}
	
	public void setBase(int base) {
		size = base;
	}

}
