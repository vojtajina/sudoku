package org.vojtajina.sudoku;

/**
 * Interface of main form
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public interface IMainView {
	/**
	 * Set value of specific field in the matrix
	 * 
	 * @param position Position of the field
	 * @param value New value of the field
	 */
	public void setValue(int position, int value);
	
	/**
	 * Enable or disable the form
	 * On disabled form, user can not change any field value
	 * 
	 * @param enabled Enabled if true, disabled otherwise
	 */
	public void setEnabled(boolean enabled);
}
