package org.vojtajina.sudoku;

/**
 * Represents one field in the matrix
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public interface IField extends Cloneable {
	
	/**
	 * Is this field solved ?
	 * Solved = only one choice value is available
	 * 
	 * @return True if only one choice 
	 */
	public boolean isSolved();
	
	/**
	 * Number of available choices
	 * If solved, then equals to 1
	 * 
	 * @return Number of choices
	 */
	public int getChoicesSize();
	
	/**
	 * Value of this field (zero if not solved)
	 * 
	 * @return Solved value of the field
	 */
	public int getValue();
	
	/**
	 * Solve this field - set value
	 * 
	 * @param val Solved value of the field
	 */
	public void setValue(int val);
	
	/**
	 * Unset one choice
	 * 
	 * @param val Unset choice value
	 * @return True if choice was unset, false otherwise
	 */
	public boolean unsetChoice(int val);
	
	/**
	 * Deep copy of the object
	 * 
	 * @return New instance of the object with same content
	 */
	public IField clone();

}
