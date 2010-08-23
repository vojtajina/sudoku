package org.vojtajina.sudoku;

/**
 * Interface for field validator
 * Field validator can check if given string is valid sudoku value.
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public interface IFieldValidator {
	
	/**
	 * Validate input
	 * 
	 * @param input String to validate
	 * @return True if given value is valid, false otherwise
	 */
	public boolean validate(String input);
	
	/**
	 * Returns sanitized value from last validation
	 * Returns zero if not valid or no validation yet
	 * 
	 * @return Sanitized integer value
	 */
	public int getCleanValue();

}
