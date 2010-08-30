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
	
	private int defaultBase;
	
	public RowIndexConverter(int base) {
		this.defaultBase = base;
	}
	
	public int getRow(int index) {
		return getRow(index, defaultBase);
	}
	
	public int getRow(int index, int base) {
		return (int) Math.floor(index / base);
	}
	
	public int getCol(int index) {
		return getCol(index, defaultBase);
	}
	
	public int getCol(int index, int base) {
		return index % base;
	}
	
	public int getIndex(int row, int col) {
		return getIndex(row, col, defaultBase);
	}
	
	public int getIndex(int row, int col, int base) {
		return row * base + col;
	}

}
