package org.vojtajina.sudoku;

/**
 * Specific implementation of IUniqueChecker for integers
 * Other implementations should use dictionary or something like that
 * With integers, it's more effective to use an array (if we know the range of possible values)
 * 
 * @author Vojta Jina <vojta.jina@gmail.com>
 */
public class UniqueCheckerInt implements IUniqueChecker<Integer> {
	
	private int range;
	private boolean[] index;

	public UniqueCheckerInt(int range) {
		this.range = range;
		reset();
	}
	
	@Override
	public boolean check(Integer item) {
		if (index[item])
			return false;
		
		index[item] = true;
		return true;
	}

	@Override
	public void reset() {
		index = new boolean[range];
	}

}
