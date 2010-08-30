package org.vojtajina.sudoku;

/**
 * Interface of main form
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public interface IMainView {
	
	/**
	 * Enable or disable the form
	 * On disabled form, user can not change any field value
	 * 
	 * @param enabled Enabled if true, disabled otherwise
	 */
	public void setEnabled(boolean enabled);
	
	public void addListener(IMainViewListener l);
}
